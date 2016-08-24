package com.github.pvoznenko.api

import java.util.UUID

import akka.http.scaladsl.server._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.github.pvoznenko.ExtractedParamType.NoExtractedParam
import com.github.pvoznenko.RootHandler
import org.scalatest.{Matchers, WordSpec}

class RootHandlerSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  class mockProjectHandler extends ProjectHandler {
    override def setRoutes(projectId:UUID): Route = {
      complete(s"$projectId projectHandlerIsCalled")
    }
  }
  class mockUserHandler extends UserHandler {
    override def setRoutes(t:NoExtractedParam): Route = {
      complete("userHandlerIsCalled")
    }
  }
  val mockRootHandler = new RootHandler(userHandler = new mockUserHandler, projectHandler = new mockProjectHandler)
  "delegate to project handler if path prefix is project" in {
    Post("/project/123e4567-e89b-12d3-a456-426655440000/SpecificPath") ~> mockRootHandler.getRoutes(()) ~> check {
      val response = responseAs[String]
      response should be ("123e4567-e89b-12d3-a456-426655440000 projectHandlerIsCalled")
    }
  }

  "delegate to user handler if path prefix is user" in {
    Post("/user/SpecificPath") ~> mockRootHandler.getRoutes(()) ~> check {
      val response = responseAs[String]
      response should be ("userHandlerIsCalled")
    }
  }
}
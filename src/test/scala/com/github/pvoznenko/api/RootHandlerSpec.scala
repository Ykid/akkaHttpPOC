package com.github.pvoznenko.api

import akka.http.scaladsl.server._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.github.pvoznenko.RootHandler
import org.scalatest.{Matchers, WordSpec}

class RootHandlerSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  class mockProjectHandler extends ProjectHandler {
    override def setRoutes(): Route = {
      complete("projectHandlerIsCalled")
    }
  }
  class mockUserHandler extends UserHandler {
    override def setRoutes(): Route = {
      complete("userHandlerIsCalled")
    }
  }
  val mockRootHandler = new RootHandler(userHandler = new mockUserHandler, projectHandler = new mockProjectHandler)
  "delegate to project handler if path prefix is project" in {
    Post("/project/SpecificPath") ~> mockRootHandler.getRoutes() ~> check {
      val response = responseAs[String]
      response should be ("projectHandlerIsCalled")
    }
  }

  "delegate to user handler if path prefix is user" in {
    Post("/user/SpecificPath") ~> mockRootHandler.getRoutes() ~> check {
      val response = responseAs[String]
      response should be ("userHandlerIsCalled")
    }
  }
}
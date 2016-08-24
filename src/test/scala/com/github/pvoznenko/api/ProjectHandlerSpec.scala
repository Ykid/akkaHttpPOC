package com.github.pvoznenko.api

import java.util.UUID

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class ProjectHandlerSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  val mockHandler = new ProjectHandler
  "return project sub paht handler response" in {
    val projectId = UUID.fromString("123e4567-e89b-12d3-a456-426655440000")
    Get("/projectSubPath") ~> mockHandler.getRoutes(projectId) ~> check {
      val response = responseAs[String]
      response should be (s"$projectId.projectSubPath")
    }
  }
}
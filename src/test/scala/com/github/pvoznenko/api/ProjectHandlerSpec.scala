package com.github.pvoznenko.api

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class ProjectHandlerSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  val mockHandler = new ProjectHandler
  "return project sub paht handler response" in {
    Get("/projectSubPath") ~> mockHandler.getRoutes() ~> check {
      val response = responseAs[String]
      response should be ("project.projectSubPath")
    }
  }
}
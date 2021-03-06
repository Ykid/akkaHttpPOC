package com.github.pvoznenko.api

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class UsersApiSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  val mockUserApi = new UserHandler
  "return user specifix path response" in {
    Post("/userSpecificPath") ~> mockUserApi.getRoutes() ~> check {
      val response = responseAs[String]
      response should not be ("")
      response should be ("user/authentication")
    }
  }
}
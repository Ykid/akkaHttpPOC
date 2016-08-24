package com.github.pvoznenko.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.HandlerAPI

class UserHandler extends HandlerAPI{
  override def setRoutes(): Route =  (path("users" / "authentication") & post) {
    complete((StatusCodes.OK,"user/authentication"))
  }
}

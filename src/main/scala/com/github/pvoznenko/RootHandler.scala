package com.github.pvoznenko

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.api.UserHandler

class RootHandler(usersApi: UserHandler) extends HandlerAPI {
  override def setRoutes(): Route = pathPrefix("v1") {
    usersApi.getRoutes()
  }
}

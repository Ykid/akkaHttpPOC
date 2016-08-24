package com.github.pvoznenko.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.HandlerAPI

class ProjectHandler extends HandlerAPI {
  override def setRoutes(): Route = path("projectSubPath") {
    complete("project.projectSubPath")
  }
}

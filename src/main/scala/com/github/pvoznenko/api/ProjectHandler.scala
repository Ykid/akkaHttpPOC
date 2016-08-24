package com.github.pvoznenko.api

import java.util.UUID

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.HandlerAPI

class ProjectHandler extends HandlerAPI[UUID] {
  override def setRoutes(projectId: UUID): Route = path("projectSubPath") {
    complete(s"$projectId.projectSubPath")
  }
}

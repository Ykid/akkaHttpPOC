package com.github.pvoznenko

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.api.{ProjectHandler, UserHandler}

class RootHandler(userHandler: UserHandler,
                  projectHandler: ProjectHandler
                 ) extends HandlerAPI[ExtractedParamType.NoExtractedParam] {
  override def setRoutes(t:Unit): Route = pathPrefix("user") {
    userHandler.getRoutes()
  } ~ pathPrefix("project"/ JavaUUID) { projectId =>
    projectHandler.getRoutes(projectId)
  }
}

package com.github.pvoznenko

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

trait HandlerAPI {
  def setRoutes():Route
  val defaultHandler = complete(StatusCodes.NotFound, "The request route can not be found")
  def getRoutes():Route = setRoutes() ~ defaultHandler
}

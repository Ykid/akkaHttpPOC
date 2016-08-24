package com.github.pvoznenko

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object ExtractedParamType {
  type NoExtractedParam = Unit
  val NO_EXTRACTED_PARAM = Unit
}

trait HandlerAPI[T] {
  def setRoutes(t:T):Route
  val defaultHandler = complete(StatusCodes.NotFound, "The request route can not be found")
  def getRoutes(t:T):Route = setRoutes(t) ~ defaultHandler
}

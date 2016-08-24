package com.github.pvoznenko.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.pvoznenko.ExtractedParamType.NoExtractedParam
import com.github.pvoznenko.HandlerAPI

class UserHandler extends HandlerAPI[NoExtractedParam]{
  override def setRoutes(t:NoExtractedParam): Route =  (path("userSpecificPath") & post) {
    complete((StatusCodes.OK,"user/authentication"))
  }
}

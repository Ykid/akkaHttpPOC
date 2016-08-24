package com.github.pvoznenko

import akka.stream.ActorMaterializer
import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import com.github.pvoznenko.utils.Config

import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Directives._
import com.github.pvoznenko.api.{ProjectHandler, UserHandler}

object Main extends App with Config {
  private implicit val system = ActorSystem()
  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  lazy val userApiHandler = new UserHandler()
  lazy val projectHandler = new ProjectHandler()
  lazy val rootHanlder = new RootHandler(userApiHandler, projectHandler)
  Http().bindAndHandle(handler = logRequestResult("log")(rootHanlder.getRoutes(())), interface = httpInterface, port = httpPort)
}
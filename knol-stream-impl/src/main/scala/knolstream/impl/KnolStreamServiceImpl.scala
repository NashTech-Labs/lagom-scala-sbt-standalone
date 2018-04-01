package knolstream.impl

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.ServiceCall
import knolstream.api.KnolStreamService
import knol.api.KnolService

import scala.concurrent.Future

/**
  * Copyright Knoldus, Inc. 2018. All rights reserved.
  * Implementation of the KnolStreamService.
  */
class KnolStreamServiceImpl(knolService: KnolService) extends KnolStreamService {
  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]] = ServiceCall { hellos =>
    Future.successful(hellos.mapAsync(8)(knolService.hello(_).invoke()))
  }
}

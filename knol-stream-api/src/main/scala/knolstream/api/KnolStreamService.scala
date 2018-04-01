package knolstream.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

/**
  * Copyright Knoldus, Inc. 2018. All rights reserved.
  * The knol stream interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the $name;format="Camel"$Stream service.
  */
trait KnolStreamService extends Service {

  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]]

  override final def descriptor: Descriptor = {
    import Service._

    named("knol-stream")
    .withCalls(
      namedCall("stream", stream)
    ).withAutoAcl(true)
  }
}

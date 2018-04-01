package knolstream.impl

import com.lightbend.lagom.scaladsl.api.Descriptor
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import knolstream.api.KnolStreamService
import knol.api.KnolService
import com.softwaremill.macwire._

/**
  * Copyright Knoldus, Inc. 2018. All rights reserved.
  */
class KnolStreamLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new KnolStreamApplication(context) {
    override def serviceLocator = NoServiceLocator
  }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new KnolStreamApplication(context) with LagomDevModeComponents

  override def describeService: Some[Descriptor] = Some(readDescriptor[KnolStreamService])
}

abstract class KnolStreamApplication(context: LagomApplicationContext)
extends LagomApplication(context)
with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[KnolStreamService](wire[KnolStreamServiceImpl])

  // Bind the $name;format="Camel"$Service client
  lazy val knol$Service = serviceClient.implement[KnolService]
}

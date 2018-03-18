import sbt._

/**
  * Copyright Knoldus, Inc. 2018. All rights reserved.
  */
object Dependencies {
  lazy val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test
}

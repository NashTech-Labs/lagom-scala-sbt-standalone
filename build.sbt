import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.knoldus",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "lagom-scala-sbt-standalone",
    libraryDependencies += scalaTest % Test,
    parallelExecution in Test := false
  )

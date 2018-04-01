import Dependencies._

organization in ThisBuild := "com.knoldus"
version in ThisBuild := "0.1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"

lazy val knol = (project in file("."))
  .aggregate(`knol-api`, `knol-impl`, `knol-stream-api`, `knol-stream-impl`)

lazy val `knol-api` = (project in file("knol-api"))
.settings(
  libraryDependencies ++= Seq(
    lagomScaladslApi
  )
)

lazy val `knol-impl` = (project in file("knol-impl"))
.enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`knol-api`)

lazy val `knol-stream-api` = (project in file("knol-stream-api"))
.settings(
  libraryDependencies ++= Seq(
    lagomScaladslApi
  )
)

lazy val `knol-stream-impl` = (project in file("knol-stream-impl"))
.enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .dependsOn(`knol-stream-api`, `knol-api`)

lagomKafkaEnabled in ThisBuild := false
lagomCassandraEnabled in ThisBuild := false

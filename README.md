# lagom-scala-sbt-standalone
A basic example of building a Lagom project (in Scala) to run outside of the Lightbend Production Suite (aka ConductR).
This was initially created from the `lagom-scala` template (`sbt new lagom/lagom-scala.g8`), with the following changes:

* Set `lagomKafkaEnabled` & `lagomCassandraEnabled` to `false`.
* Added a static service location to hello-impl for cas_native (the Cassandra server).
* Added a static service location to hello-stream-impl for Kafka service (unnamed).

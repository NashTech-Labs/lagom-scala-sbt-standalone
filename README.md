# lagom-scala-sbt-standalone
A basic example of building a Lagom project (in Scala) to run outside of the Lightbend Production Suite (aka ConductR).
This was initially created from the `lagom-scala` template (`sbt new lagom/lagom-scala.g8`), with the following changes:

* Set `lagomKafkaEnabled` & `lagomCassandraEnabled` to `false`.
* Added a static service location to hello-impl for cas_native (the Cassandra server).
* Added a static service location to hello-stream-impl for Kafka service (unnamed).

To test this:

 1. Open a terminal and clone the repository to your workstation (`git clone https://github.com/knoldus/lagom-scala-sbt-standalone.git`)
 2. `cd lagom-scala-sbt-standalone`
 3. `sbt` to enter the sbt console
 4. `project knol-impl` to select `knol-impl` module.
 5.  `dist` (from the sbt prompt) to create distribution package.
 6.  Press control-C to exit `sbt` console.
 7.  Start Cassandra Server - https://www.datastax.com/2012/01/getting-started-with-cassandra
 8.  Start Kafka Server - https://kafka.apache.org/quickstart#quickstart_download
 9.  `cd lagom-scala-sbt-standalone/knol-impl/target/universal`
 10. `unzip knol-impl-0.1.0-SNAPSHOT.zip`
 11. Set the following environment varaibles:
      1. `export APP_LIB=knol-impl-0.1.0-SNAPSHOT/lib`
      2. `export APP_CLASSPATH=$APP_LIB/*`
      3. `export JAVA_OPTS=""`
      4. `export JMX_CONFIG=""`
      5. `export PLAY_SECRET=none`
      6. `export CONFIG_FILE=/path/to/lagom-scala-sbt-standalone/knol-impl/src/main/resources/application.conf`
      7. `export CONFIG="-Dplay.crypto.secret=$PLAY_SECRET -Dlagom.cluster.join-self=off -Dorg.xerial.snappy.use.systemlib=true -Dconfig.file=$CONFIG_FILE"`
      8. `export PLAY_SERVER_START="play.core.server.ProdServerStart"`
 12. At last run the Lagom service - `java -cp "$APP_CLASSPATH" $JAVA_OPTS $JMX_CONFIG $CONFIG $PLAY_SERVER_START`

This runs each of the services as single-node clusters.

You can press control-C to exit the services.

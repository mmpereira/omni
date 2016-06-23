organization := "com.awesome"
name := "omni-core"
version := "0.0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor"    % "2.4.7",
	"com.typesafe.akka" %% "akka-testkit"  % "2.4.7"% "test",
	
	
	"org.scalaj" %% "scalaj-http" % "2.3.0",
	
	"org.quartz-scheduler" % "quartz" % "2.2.1",
	
	"org.slf4j" % "slf4j-simple" % "1.7.21",
	
	
	"com.awesome" %% "omni-task" % "0.0.1"
)
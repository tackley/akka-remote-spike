organization := "net.tackley.akka"

name := "akka-remote-publisher"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor" % "2.0-RC1",
  "com.typesafe.akka" % "akka-remote" % "2.0-RC1",
  "com.typesafe.akka" % "akka-agent" % "2.0-RC1"
)
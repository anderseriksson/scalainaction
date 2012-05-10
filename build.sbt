
organization := "name.heikoseeberger.scalainaction"

name := "scalainaction"

version := "1.0.0"

scalaVersion := "2.9.1"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor" % "2.0",
  "net.databinder" %% "dispatch-http" % "0.8.8",
  "net.databinder" %% "unfiltered-netty-server" % "0.6.1",
  "org.specs2" %% "specs2" % "1.8.2" % "test"
)

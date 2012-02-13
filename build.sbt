
organization := "name.heikoseeberger.scalainaction"

name := "scalainaction"

version := "1.0.0"

scalaVersion := "2.9.1"

resolvers += "Akka Repository" at "http://akka.io/repository"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor" % "2.0-RC1",
  "net.databinder" %% "dispatch-http" % "0.8.7",
  "net.databinder" %% "unfiltered-netty-server" % "0.5.3",
  "org.specs2" %% "specs2" % "1.7.1" % "test"
)


organization := "name.heikoseeberger.scalainaction"

name := "scalainaction"

version := "1.0.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "net.databinder" %% "dispatch-http" % "0.8.8",
  "org.specs2" %% "specs2" % "1.8.2" % "test"
)

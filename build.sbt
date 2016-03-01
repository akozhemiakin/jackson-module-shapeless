import sbt.Keys._

lazy val noPublish = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)

lazy val versions = new {
  val jackson = "2.7.2"
  val shapeless = "2.2.5"
}

lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  organization := "ru.arkoit.jackson.module.shapeless",
  scalaVersion := "2.11.7",
  autoAPIMappings := true,
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  ),
  scalacOptions ++= Seq("-feature", "-language:implicitConversions"),
  crossScalaVersions := Seq("2.11.7", "2.10.6")
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(noPublish)
  .settings(
    moduleName := "shapeless",
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-databind" % versions.jackson,
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jackson,
      "com.chuusai" %% "shapeless" % versions.shapeless
    )
  )

import sbt.Keys._

lazy val commonSettings = Seq(
  version := "0.1.1",
  organization := "ru.arkoit.jackson.module",
  scalaVersion := "2.11.7",
  autoAPIMappings := true,
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  ),
  scalacOptions ++= Seq("-feature", "-language:implicitConversions"),
  crossScalaVersions := Seq("2.11.7", "2.10.6")
)

lazy val noPublish = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomIncludeRepository := { _ => false },
  licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  homepage := Some(url("https://github.com/akozhemiakin/jackson-module-shapeless")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/akozhemiakin/jackson-module-shapeles"),
      "scm:git:git@github.com:akozhemiakin/jackson-module-shapeless.git"
    )
  ),
  pomExtra := (
      <developers>
        <developer>
          <id>akozhemiakin</id>
          <name>Artem Kozhemiakin</name>
          <url>http://arkoit.ru</url>
        </developer>
      </developers>)
)

lazy val versions = new {
  val jackson = "2.5.3"
  val shapeless = "2.2.5"
}

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    moduleName := "jackson-module-shapeless",
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-databind" % versions.jackson,
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jackson,
      "com.chuusai" %% "shapeless" % versions.shapeless
    )
  )

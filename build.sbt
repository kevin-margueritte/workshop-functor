import Dependencies.Library._
import Dependencies.Plugin._

lazy val root = (project in file("."))
  .settings(generalSettings)
  .dependsOn(core)

lazy val core = (project in file("modules/core"))
  .settings(generalSettings)
  .settings(libraryDependencies ++= cats :: scalatest :: scalacheck :: enumeratum :: Nil)
  .settings(libraryDependencies ++= circe)

lazy val generalSettings = Seq(
  organization := "com.mrgueritte",
  scalaVersion := "2.12.4",
  version      := "0.0.1",
  scalacOptions ++= Seq(
    "-deprecation", // Warn when deprecated API are used
    "-feature", // Warn for usages of features that should be importer explicitly
    "-unchecked", // Warn when generated code depends on assumptions
    "-Ywarn-dead-code", // Warn when dead code is identified
    "-Ywarn-numeric-widen", // Warn when numeric are widened
    "-Xlint", // Additional warnings (see scalac -Xlint:help)
    "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receive
    "-language:postfixOps",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:existentials",
    "-language:higherKinds",
    "-language:experimental.macros"
  ),
  addCompilerPlugin(kindProjector)
)
  



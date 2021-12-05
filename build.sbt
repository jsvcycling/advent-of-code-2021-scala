ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-2021-scala",
    idePackagePrefix := Some("com.jsvcycling.aoc2021")
  )

lazy val runDay1 = taskKey[Unit]("Run Day 1 Solutions")
lazy val runDay2 = taskKey[Unit]("Run Day 2 Solutions")

runDay1 := (Compile / runMain).toTask(" com.jsvcycling.aoc2021.Day1").value
runDay2 := (Compile / runMain).toTask(" com.jsvcycling.aoc2021.Day2").value

libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"
name := "priority-queue"

organization := "gm.interviews"

version := "0.0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test" withSources() withJavadoc()
)

initialCommands := "import gm.interviews.priorityqueue._"


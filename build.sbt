import sbt.util

name := "workassignment1"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.2.0"

showSuccess := false
logLevel in run := util.Level.Error

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.46" % "provided"


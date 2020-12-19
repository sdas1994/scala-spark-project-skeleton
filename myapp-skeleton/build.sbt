name := "myapp"
version := "0.1"
scalaVersion := "2.12.10"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided",
  "org.apache.spark" %% "spark-mllib" % "3.0.1" % "provided",
  "org.apache.hadoop" % "hadoop-client" % "2.8.5" % "provided",
  "org.json4s" % "json4s-native_2.12" % "3.6.10",
  "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.4",
)
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case PathList("org", "apache", "spark", "unused", "UnusedStubClass.class") =>
    MergeStrategy.first
  case _ => MergeStrategy.first
}

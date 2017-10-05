
name := "webtictactoe"

version := "0.1"

scalaVersion := "2.12.3"

resolvers += "Bintray" at "https://dl.bintray.com/sbt/sbt-plugin-releases/"
resolvers += "Clojars" at "https://clojars.org/repo"

//disable cross path file naming (simplify deploy process)
crossPaths := false

//set the options for JUnit to display JUnit test logging on success (otherwise it is suppressed)
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

//set heroku deploy config
herokuFatJar in Compile := Some((assemblyOutputPath in assembly).value)
herokuJdkVersion in Compile := "1.8"
herokuAppName in Compile := "young-shelf-68199"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.clojars.kyleannen" % "javaserver" % "0.4.0",
  "org.clojars.kyleannen" % "tictactoe" % "0.2.1"
)

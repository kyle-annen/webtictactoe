name := "webtictactoe"

version := "0.1"

scalaVersion := "2.12.3"

resolvers += "Clojars" at "https://clojars.org/repo"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.clojars.kyleannen" % "javaserver" % "0.1.1"
libraryDependencies += "org.clojars.kyleannen" % "tictactoe" % "0.2"

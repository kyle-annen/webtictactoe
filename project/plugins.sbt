addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("com.heroku" % "sbt-heroku" % "2.0.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.2")

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.2")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.0.2")


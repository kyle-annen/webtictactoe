
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

jacocoReportSettings := JacocoReportSettings(
  "File output settings",
  None,
  JacocoThresholds(),
  Seq(JacocoReportFormats.XML),
  "utf-8")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.clojars.kyleannen" % "javaserver" % "0.4.0",
  "org.clojars.kyleannen" % "tictactoe" % "0.2.1"
)

pomExtra :=
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
    </license>
  </licenses>
    <url>http://github.com/kyle-annen/webtictactoe</url>
    <scm>
      <connection>
        scm:git:git://github.com/kyle-annen/webtictactoe.git
      </connection>
      <developerConnection>
        scm:git:ssh://github.com:kyle-annen/webtictactoe.git
      </developerConnection>
      <url>
        http://github.com/kyle-annen/webtictactoe/tree/master
      </url>
    </scm>
    <distributionManagement>
      <repository>
        <id>clojars</id>
        <name>Clojars repository</name>
        <url>https://clojars.org/repo</url>
      </repository>
    </distributionManagement>
    <build>
      <sourceDirectory>src/main/scala</sourceDirectory>
      <testSourceDirectory>src/test/scala</testSourceDirectory>
      <plugins>
        <plugin>
          <groupId>net.alchim31.maven</groupId>
          <artifactId>scala-maven-plugin</artifactId>
          <version>3.3.1</version>
        </plugin>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.1</version>
          <configuration>
            <source>1.7</source>
            <target>1.7</target>
          </configuration>
        </plugin>
      </plugins>
    </build>

import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "LevelUp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "com.github.aselab" %% "scala-activerecord" % "0.2.3",
    "org.slf4j" % "slf4j-nop" % "1.7.5",
    "com.h2database" % "h2" % "1.3.173"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}

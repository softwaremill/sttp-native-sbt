scalaVersion := "3.3.0"

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.releaseFast) // releaseFast
    .withGC(GC.commix) // commix
}

libraryDependencies ++= List(
  "com.softwaremill.sttp.client4" %%% "core" % "4.0.0-M2",
  "org.typelevel" %%% "cats-effect" % "3.5.1"
)

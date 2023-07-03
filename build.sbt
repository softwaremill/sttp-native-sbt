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
  "com.softwaremill.sttp.client4" %% "core_native0.4" % "4.0.0-M1",
  "org.typelevel" %% "cats-effect_native0.4" % "3.5.1"
)

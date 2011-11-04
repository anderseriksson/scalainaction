
// Add java source directories in compile (if removed elsewhere)
unmanagedSourceDirectories in Compile <<= (scalaSource in Compile, javaSource in Compile)(Seq(_, _))

// Add java source directories in test (if removed elsewhere)
unmanagedSourceDirectories in Test <<= (scalaSource in Test, javaSource in Test)(Seq(_, _))

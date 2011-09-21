import dispatch.{ :/, Http }
import scala.xml.NodeSeq

object Weather {

  private val locations = Seq(
    "Berlin-Germany",
    "Cologne-Germany",
    "Hamburg-Germany",
    "Munich-Germany",
    "Nuremberg-Germany",
    "Passau-Germany",
    "Stuttgart-Germany",
    "Bath-England",
    "London-England",
    "Manchester-England",
    "Dublin-Ireland",
    "Lille-France",
    "Marseille-France",
    "Paris-France",
    "Boston-USA",
    "Chicago-USA",
    "Dallas-USA",
    "Denver-USA",
    "Los Angeles-USA",
    "Miami-USA",
    "New Orleans-USA",
    "New York-USA",
    "San Francisco-USA",
    "Seattle-USA"
  )

  def main(args: Array[String]): Unit = {

    val isParallel = args.headOption map (_ == "par") getOrElse false
    val time0 = System.currentTimeMillis
    val currentTemperatures =
      if (isParallel) locations.par flatMap currentTemperature
      else locations flatMap currentTemperature
    val time1 = System.currentTimeMillis
    val averageTemperature = currentTemperatures.sum / currentTemperatures.size

    println(
      "Calculated average temperature (%s out of %s) of about %s °C in %s ms.".format(
        currentTemperatures.size,
        locations.size,
        averageTemperature,
        time1 - time0
      )
    )
  }

  def currentTemperature(location: String): Option[Int] = {
    val request = :/("www.google.com") / "ig" / "api" <<? Map("weather" -> location, "hl" -> "en")
    val http = new Http
    try http(request <> extractTemperature) finally http.shutdown()
  }

  def extractTemperature(weatherResponse: NodeSeq): Option[Int] =
    try {
      (weatherResponse \\ "current_conditions" \ "temp_c" \ "@data").headOption map (_.text.toInt)
    } catch {
      case _: Exception => None
    }
}

// The following is only possible in 2.10 because of https://issues.scala-lang.org/browse/SI-4843!    
//    val currentTemperatures =
//      (if (isParallel) locations.par else locations) flatMap currentTemperature

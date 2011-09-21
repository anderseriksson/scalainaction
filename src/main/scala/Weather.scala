import dispatch._
import scala.util.control.Exception._
import scala.xml.Elem

object Weather {

  def main(args: Array[String]): Unit = {

    val locations = Seq(
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
      "Seattle-USA")

    val isParallel = args.headOption map { _ == "par" } getOrElse false
    val time0 = System.currentTimeMillis
    val currentTemperatures =
      if (isParallel) (locations.par map currentTemperature).flatten.seq
      else (locations map currentTemperature).flatten
    val time1 = System.currentTimeMillis
    val averageTemperature = currentTemperatures.sum / currentTemperatures.size

    println("Calculated average temperature (%s out of %s) of about %s °C in %s ms.".format(
      currentTemperatures.size,
      locations.size,
      averageTemperature,
      time1 - time0))
  }

  def currentTemperature(location: String): Option[Int] =
    catching(classOf[Exception]) opt {
      def extractTemperature(weatherResponse: Elem) =
        (weatherResponse \\ "current_conditions" \ "temp_c").headOption map { temp => (temp \ "@data").text.toInt }
      val weatherRequest = :/("www.google.com") / "ig" / "api" <<? Map("weather" -> location, "hl" -> "en")
      Http(weatherRequest <> extractTemperature)
    } flatMap { x => x }
}

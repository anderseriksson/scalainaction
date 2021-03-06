case class Time(hours: Int = 0, minutes: Int = 0) {

  val asMinutes = hours * 60 + minutes

  def -(that: Time) = minus(that)

  def minus(that: Time) = this.asMinutes - that.asMinutes
}

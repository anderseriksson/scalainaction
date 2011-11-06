public class JavaTime {

  private final int hours;

  private final int minutes;

  private final int asMinutes;

  public JavaTime(int hours, int minutes) {
    this.hours = hours;
    this.minutes = minutes;
    this.asMinutes = hours * 60 + minutes;
  }

  public int getHours() {
    return hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getAsMinutes() {
    return asMinutes;
  }

  public int minus(JavaTime that) {
    return this.asMinutes - that.asMinutes;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JavaTime other = (JavaTime) obj;
    if (hours != other.hours)
      return false;
    if (minutes != other.minutes)
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + hours;
    result = prime * result + minutes;
    return result;
  }
}

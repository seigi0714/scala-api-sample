package Helper

import java.time.LocalDate
import java.time.temporal.ChronoUnit

case class DateHelper() {
  def calcAge(birthDay: LocalDate): Int = {
    val today = LocalDate.now()
    ChronoUnit.YEARS.between(birthDay, today).toInt
  }
}

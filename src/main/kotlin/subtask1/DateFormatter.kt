package subtask1

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        try {
            val formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT)
            val actualMonth = if (month.length > 1) month else "0$month"
            val actualDay = if (day.length > 1) day else "0$day"

            val date = LocalDate.parse("$actualDay-$actualMonth-$year", formatter)
            println(date)
            println(date.dayOfWeek)
            val actualMonthText = when (date.month) {
                Month.JANUARY -> "января"
                Month.FEBRUARY -> "февраля"
                Month.MARCH -> "марта"
                Month.APRIL -> "апреля"
                Month.MAY -> "мая"
                Month.JUNE -> "июня"
                Month.JULY -> "июля"
                Month.AUGUST -> "августа"
                Month.SEPTEMBER -> "сентября"
                Month.OCTOBER -> "октября"
                Month.NOVEMBER -> "ноября"
                Month.DECEMBER -> "декабря"
            }
            val dayOfWeek = when (date.dayOfWeek) {
                DayOfWeek.SUNDAY -> "воскресенье"
                DayOfWeek.MONDAY -> "понедельник"
                DayOfWeek.TUESDAY -> "вторник"
                DayOfWeek.WEDNESDAY -> "среда"
                DayOfWeek.THURSDAY -> "четверг"
                DayOfWeek.FRIDAY -> "пятница"
                DayOfWeek.SATURDAY -> "суббота"
            }
            return "$actualDay $actualMonthText, $dayOfWeek"
        } catch (ex: Throwable) {
            return "Такого дня не существует"
        }
    }
}



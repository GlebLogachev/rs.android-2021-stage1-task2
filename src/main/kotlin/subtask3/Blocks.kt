package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
    //val array = arrayOf(1, 1, 4, "5","qwe", LocalDate.parse("1998-03-14"))
    return when (blockB) {
        String::class -> {
            var sumStr = ""
            blockA.forEach {
                if (it is String)
                    sumStr += it
            }
            println(sumStr)
            return sumStr
        }
        Int::class -> {
            var intSum = 0
            blockA.forEach {
                if (it is Int)
                    intSum += it
            }
            println("heelo" + intSum)
            return intSum
        }
        LocalDate::class -> {
            var currDate: LocalDate = LocalDate.parse("1998-03-14")
            blockA.forEach {
                @Suppress("CAST_NEVER_SUCCEEDS")
                (it as? LocalDate)?.let { date ->
                    if (date.isAfter(currDate)) {
                        currDate = date
                    }
                }
            }
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            return currDate.format(formatter).replace("-",".")
        }
        else -> println("такое невозможно")
    }
}
}

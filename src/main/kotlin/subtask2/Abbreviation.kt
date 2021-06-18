package subtask2

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        var list: String = ""
        for (i in a) {
            if (b.contains(i.toUpperCase()))
                list += i.toUpperCase()
        }
        return if (list == b) {
            "YES"
        } else {
            "NO"
        }
    }
}

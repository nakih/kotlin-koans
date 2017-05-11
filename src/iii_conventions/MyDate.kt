package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year != other.year) {
            return this.year.compareTo(other.year)
        }
        if (this.month != other.month) {
            return this.month.compareTo(other.month)
        }
        if (this.dayOfMonth != other.dayOfMonth) {
            return this.dayOfMonth.compareTo(other.dayOfMonth)
        }
        return 0
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

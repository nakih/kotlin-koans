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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator() = DateIterator(this)
}

class DateIterator(val range: DateRange) : Iterator<MyDate> {
    var current = range.start
    override fun next(): MyDate {
        val temp = current
        current = current.nextDay()
        return temp
    }

    override fun hasNext(): Boolean = current <= range.endInclusive
}
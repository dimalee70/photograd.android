package photograd.kz.photograd.models.enums



enum class DateFormat(val value: String)
{
    iso8601("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ"),
    iso8601millisec("yyyy-MM-dd'T'HH:mm:ss"),
    dayMonth("dd.MM"),
    dayMonthYear("dd.MM.yyyy")
}
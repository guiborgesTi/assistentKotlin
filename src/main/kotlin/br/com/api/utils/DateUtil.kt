package br.com.api.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

 class DateUtil  {


    fun parseDate(pattern: String?): Date {
        val date = LocalDateTime.now()
        val formater =  SimpleDateFormat(pattern)
        return formater.parse(formater.format(Date.from(date.atZone(ZoneId.systemDefault()).toInstant())))
    }
}


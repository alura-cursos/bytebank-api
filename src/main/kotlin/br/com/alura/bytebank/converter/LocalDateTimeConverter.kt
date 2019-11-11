package br.com.alura.bytebank.converter

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class LocalDateTimeConverter : AttributeConverter<LocalDateTime, Timestamp> {

    override fun convertToDatabaseColumn(date: LocalDateTime?) =
            date?.let { Timestamp.valueOf(date) }

    override fun convertToEntityAttribute(value: Timestamp?) =
            value?.let { value.toLocalDateTime() }

}
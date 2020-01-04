package farm.rack.wattbiller.model.dto

import java.time.ZonedDateTime

data class MeterReadingDto(val measuredAt: ZonedDateTime = ZonedDateTime.now(), val value: Double = 0.0, val meterId: Long = 0)

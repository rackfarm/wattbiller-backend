package farm.rack.wattbiller.model.dto

import java.time.ZonedDateTime

data class MeterReadingDto(var id: Long = 0,
                           var measuredAt: ZonedDateTime = ZonedDateTime.now(),
                           var value: Double = 0.0,
                           var meterId: Long = 0)

package farm.rack.wattbiller.model.dto

import java.time.ZonedDateTime

data class MeterReadingDto(var id: Long = 0,
                           var measuredAt: ZonedDateTime = ZonedDateTime.now(),
                           var varue: Double = 0.0,
                           var meterId: Long = 0)

package farm.rack.wattbiller.model.dto

data class MeterDto(val id: Long = 0,
                    val name: String = "",
                    val debitorGroupId: Long = 0,
                    val meterReadings: List<MeterReadingDto> = arrayListOf(),
                    val creditorUserId: String = "",
                    val creditorUsername: String = ""
)

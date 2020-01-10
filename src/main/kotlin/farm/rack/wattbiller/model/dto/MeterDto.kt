package farm.rack.wattbiller.model.dto

data class MeterDto(var id: Long = 0,
                    var name: String = "",
                    var debitorGroupId: Long = 0,
                    var meterReadings: List<MeterReadingDto> = arrayListOf(),
                    var creditorUserId: String = "",
                    var creditorUsername: String = ""
)

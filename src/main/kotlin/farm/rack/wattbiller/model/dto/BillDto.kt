package farm.rack.wattbiller.model.dto

data class BillDto(val id: Long = 0,
                   val amount: Double = 0.0,
                   val meterName: String = "",
                   val meterId: Long = 0,
                   val debitorGroupDto: DebitorGroupDto = DebitorGroupDto())
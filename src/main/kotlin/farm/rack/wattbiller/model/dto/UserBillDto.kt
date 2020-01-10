package farm.rack.wattbiller.model.dto

data class UserBillDto(var id: Long = 0,
                       var periodName: String = "",
                       var username: String = "",
                       var entries: List<UserBillEntryDto> = arrayListOf(),
                       var amount: Double = 0.0)

data class UserBillEntryDto(var meterName: String = "", var cost: Double = 0.0, var userBillId: Long = 0)

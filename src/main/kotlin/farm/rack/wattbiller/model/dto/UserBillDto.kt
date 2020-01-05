package farm.rack.wattbiller.model.dto

data class UserBillDto(val id: Long = 0, val periodName: String ="", val username: String, val entries: List<UserBillEntryDto>)

data class UserBillEntryDto(val meterName: String = "", val cost: Double = 0.0, val userBillId: Long = 0)

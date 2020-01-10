package farm.rack.wattbiller.model.dto

data class DebitorGroupMemberDto(var username: String = "",
                                 var percentage: Double = 0.0,
                                 var debitorGroupId: Long = 0) : Dto()

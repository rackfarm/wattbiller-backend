package farm.rack.wattbiller.model.dto

data class DebitorGroupMemberDto(var id: Long = 0,
                                 var username: String = "",
                                 var percentage: Double = 0.0,
                                 var debitorGroupId: Long = 0)

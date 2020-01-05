package farm.rack.wattbiller.model.dto

data class DebitorGroupMemberDto(val id: Long = 0,
                                 val username: String = "",
                                 val percentage: Double = 0.0,
                                 val debitorGroupId: Long = 0)

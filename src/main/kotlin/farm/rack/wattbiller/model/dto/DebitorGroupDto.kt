package farm.rack.wattbiller.model.dto

import farm.rack.wattbiller.model.DebitorGroupMembership

data class DebitorGroupDto(var id: Long = 0,
                           var name: String = "",
                           var members: List<DebitorGroupMemberDto> = arrayListOf())

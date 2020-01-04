package farm.rack.wattbiller.model.dto

import farm.rack.wattbiller.model.DebitorGroupMembership

data class DebitorGroupDto(val id: Long = 0, val name: String = "", val members: List<DebitorGroupMemberDto> = arrayListOf())
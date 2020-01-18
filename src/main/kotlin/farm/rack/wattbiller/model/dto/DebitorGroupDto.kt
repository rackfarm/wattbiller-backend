package farm.rack.wattbiller.model.dto

data class DebitorGroupDto(var id: Long = 0,
                           var name: String = "",
                           var members: List<DebitorGroupMemberDto> = arrayListOf())

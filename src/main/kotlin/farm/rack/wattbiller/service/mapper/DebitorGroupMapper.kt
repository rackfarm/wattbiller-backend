package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.dto.DebitorGroupDto
import org.mapstruct.Mapper

@Mapper
interface DebitorGroupMapper {
    fun debitorGroupToDebitorGroupDto(debitorGroup: DebitorGroup): DebitorGroupDto
    fun debitorGroupDtoToDebitorGroup(debitorGroupDto: DebitorGroupDto): DebitorGroup
}

package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.dto.DebitorGroupDto
import org.mapstruct.Mapper

@Mapper
interface DebitorGroupMapper {
    fun toDto(debitorGroup: DebitorGroup): DebitorGroupDto
    fun toEntity(debitorGroupDto: DebitorGroupDto): DebitorGroup
}

package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.jpa.MeterRepository
import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.dto.DebitorGroupDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [MeterMapper::class, DebitorGroupMembershipMapper::class, EntityReferenceResolver::class], componentModel = "jsr330")
interface DebitorGroupMapper {
    fun toDto(debitorGroup: DebitorGroup): DebitorGroupDto
    @Mappings(
            Mapping(target = "memberMap", ignore = true),
            Mapping(target = "meters", source = "id")

    )
    fun toEntity(debitorGroupDto: DebitorGroupDto): DebitorGroup
}

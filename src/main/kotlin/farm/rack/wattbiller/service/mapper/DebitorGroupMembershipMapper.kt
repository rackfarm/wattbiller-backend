package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.DebitorGroupMembership
import farm.rack.wattbiller.model.dto.DebitorGroupMemberDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [EntityReferenceResolver::class], componentModel = "jsr330")
interface DebitorGroupMembershipMapper {
    @Mappings(
            Mapping(target = "debitorGroupId", source = "debitorGroup.id"),
            Mapping(target = "username", source = "user.username")
    )
    fun toDto(debitorGroupMembership: DebitorGroupMembership): DebitorGroupMemberDto

    @Mappings(
            Mapping(target = "debitorGroup", source = "debitorGroupId"),
            Mapping(target = "user", source = "username", qualifiedByName = ["findByUsername"])
    )
    fun toEntity(debitorGroupMemberDto: DebitorGroupMemberDto): DebitorGroupMembership
}

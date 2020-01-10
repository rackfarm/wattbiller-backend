package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.jpa.UserRepository
import farm.rack.wattbiller.model.DebitorGroupMembership
import farm.rack.wattbiller.model.dto.DebitorGroupMemberDto
import org.mapstruct.Mapper
import javax.inject.Inject

@Mapper(uses = [EntityReferenceResolver::class], componentModel = "cid")
interface DebitorGroupMembershipMapper {
    fun toDto(debitorGroupMembership: DebitorGroupMembership): DebitorGroupMemberDto
    fun toEntity(debitorGroupMemberDto: DebitorGroupMemberDto): DebitorGroupMembership
}

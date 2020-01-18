package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.Meter
import farm.rack.wattbiller.model.dto.MeterDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(uses = [MeterReadingMapper::class, EntityReferenceResolver::class], componentModel = "jsr330")
interface MeterMapper {

    @Mappings(
            Mapping(target = "debitorGroupId", source = "debitorGroup.id"),
            Mapping(target = "creditorUserId", source = "creditor.userId"),
            Mapping(target = "creditorUsername", source = "creditor.username")
    )
    fun toDto(meter: Meter): MeterDto

    @Mappings(
            Mapping(target = "debitorGroup", source = "debitorGroupId"),
            Mapping(target = "creditor", source = "creditorUserId")
    )
    fun toEntity(meterDto: MeterDto): Meter
}

package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.Meter
import farm.rack.wattbiller.model.dto.MeterDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(uses = [MeterReadingMapper::class,  EntityReferenceResolver::class], componentModel = "jsr330")
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

    //
//    override fun fromDto(dto: MeterDto): Meter {
//        if (!debitorGroupRepository.existsById(dto.debitorGroupId)) {
//            throw ValidationException("No DebitorGroup with id: ${dto.debitorGroupId} exists")
//        }
//        val debitorGroup = debitorGroupRepository.findById(dto.debitorGroupId).get()
//        val meterReadings = meterReadingRepository.findByMeterId(dto.id)
//        val user = userRepository.findById(dto.creditorUserid).get()
//        return Meter(dto.name, debitorGroup, meterReadings, user)
//    }
//
//    override fun toDto(entity: Meter): MeterDto {
//        return MeterDto(entity.id, entity.name, entity.debitorGroup.id,
//                entity.readings.map { meterReadingMapper.toDto(it) },
//                entity.creditor.userId, entity.creditor.username)
//    }
}

package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.jpa.DebitorGroupRepository
import farm.rack.wattbiller.jpa.MeterReadingRepository
import farm.rack.wattbiller.jpa.UserRepository
import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.Meter
import farm.rack.wattbiller.model.MeterReading
import farm.rack.wattbiller.model.dto.MeterDto
import farm.rack.wattbiller.model.dto.MeterReadingDto
import org.mapstruct.Mapper
import javax.inject.Inject
import javax.inject.Singleton
import javax.validation.ValidationException


@Mapper
interface MeterMapper {

    fun meterToMeterDto(meter: Meter): MeterDto
    fun meterDtoToMeter(meterDto: MeterDto): Meter

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

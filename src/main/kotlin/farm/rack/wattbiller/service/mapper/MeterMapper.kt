package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.jpa.MeterReadingRepository
import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.Meter
import farm.rack.wattbiller.model.MeterReading
import farm.rack.wattbiller.model.dto.MeterDto
import farm.rack.wattbiller.model.dto.MeterReadingDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MeterMapper: Mapper<Meter, MeterDto> {

    @Inject lateinit var meterReadingMapper: Mapper<MeterReading, MeterReadingDto>
    @Inject lateinit var meterReadingRepository: MeterReadingRepository

    override fun fromDto(dto: MeterDto): Meter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toDto(entity: Meter): MeterDto {
        return MeterDto(entity.id, entity.name, entity.debitorGroup.id, entity.readings.map { meterReadingMapper.toDto(it) })
    }
}
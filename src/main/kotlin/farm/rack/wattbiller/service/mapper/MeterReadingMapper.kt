package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.MeterReading
import farm.rack.wattbiller.model.dto.MeterReadingDto
import org.mapstruct.Mapper

@Mapper
interface MeterReadingMapper {

    fun meterReadingToMeterReadingDto(meterReading: MeterReading): MeterReadingDto
    fun meterReadingDtoToMeterReading(meterReadingDto: MeterReadingDto): MeterReading
//
//    @Inject
//    lateinit var meterRepository: MeterRepository
//
//    override fun fromDto(dto: MeterReadingDto): MeterReading {
//        val meter = meterRepository.findById(dto.meterId).get()
//        val meterReading = MeterReading(meter, dto.measuredAt, dto.value)
//        meterReading.id = dto.id
//        return meterReading
//    }
//
//    override fun toDto(entity: MeterReading): MeterReadingDto {
//        return MeterReadingDto(entity.id, entity.timeWhenMeasured, entity.value, entity.meter.id)
//    }
}

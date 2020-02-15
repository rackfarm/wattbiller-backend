package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.MeterReading
import farm.rack.wattbiller.model.dto.MeterReadingDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [EntityReferenceResolver::class], componentModel = "jsr330")
interface MeterReadingMapper {

    @Mapping(target = "meterId", source = "meter.id")
    fun toDto(meterReading: MeterReading): MeterReadingDto

    @Mappings(
            Mapping(target = "meter", source = "meterId"),
            Mapping(target = "billedWithinPeriod", ignore = true)
    )
    fun toEntity(meterReadingDto: MeterReadingDto): MeterReading

}

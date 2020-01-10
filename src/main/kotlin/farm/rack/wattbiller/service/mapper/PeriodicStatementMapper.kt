package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.PeriodicStatement
import farm.rack.wattbiller.model.dto.PeriodicStatementDto
import io.micronaut.data.annotation.MappedEntity
import org.mapstruct.*

@Mapper(uses = [MeterReadingMapper::class, EntityReferenceResolver::class])
interface PeriodicStatementMapper {
    @Mappings(
            Mapping(source = "debitorGroup.id", target = "debitorGroupId"),
            Mapping(source = "debitorGroup.name", target = "debitorGroupName"),
            Mapping(source = "billingPeriod.startDate", target  = "periodStartDate"),
            Mapping(source = "billingPeriod.endDate", target  = "periodEndDate"),
            Mapping(source = "meter.id", target = "meterId"),
            Mapping(source = "meter.name", target = "meterName")
    )
    fun toDto(periodicStatement: PeriodicStatement): PeriodicStatementDto

    @Mappings(
            Mapping(source = "debitorGroupId", target = "debitorGroup"),
            Mapping(source = "meterId", target = "meter")
    )
    fun toEntity(periodicStatementDto: PeriodicStatementDto): PeriodicStatement
}

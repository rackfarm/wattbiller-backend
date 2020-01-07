package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.PeriodicStatement
import farm.rack.wattbiller.model.dto.PeriodicStatementDto
import org.mapstruct.Mapper

@Mapper
interface PeriodicStatementMapper {
    fun toDto(periodicStatement: PeriodicStatement): PeriodicStatementDto
    fun toEntity(periodicStatementDto: PeriodicStatementDto): PeriodicStatement
}

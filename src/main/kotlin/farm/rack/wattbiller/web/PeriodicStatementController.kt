package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.PeriodicStatementDto
import farm.rack.wattbiller.service.PeriodicStatementService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/periodicStatement")
class PeriodicStatementController {
    @Inject
    lateinit var periodicStatementService: PeriodicStatementService

    @Post
    fun createPeriodicStatement(@Body periodicStatement: PeriodicStatementDto): PeriodicStatementDto {
        return periodicStatementService.create(periodicStatement)
    }

    @Get("/all")
    fun readAll(): List<PeriodicStatementDto> {
        return periodicStatementService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): PeriodicStatementDto {
        return periodicStatementService.readById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long) {
        periodicStatementService.delete(id)
    }
}

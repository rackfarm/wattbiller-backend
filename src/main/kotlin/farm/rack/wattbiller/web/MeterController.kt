package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.MeterDto
import farm.rack.wattbiller.service.crud.MeterService
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import javax.inject.Inject

@Controller("/api/meter")
@Secured(SecurityRule.IS_AUTHENTICATED)
class MeterController {

    @Inject
    lateinit var meterService: MeterService

    @Post
    @Secured("wattbiller-admin")
    fun createMeter(@Body meter: MeterDto): MeterDto {
        return meterService.create(meter)
    }

    @Get("/all")
    fun readAll(): List<MeterDto> {
        return meterService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): MeterDto {
        return meterService.readById(id)
    }

    @Delete("/{id}")
    @Secured("wattbiller-admin")
    fun deleteById(@PathVariable id: Long) {
        meterService.delete(id)
    }
}

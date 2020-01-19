package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.MeterDto
import farm.rack.wattbiller.service.MeterService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/meter")
class MeterController {

    @Inject
    lateinit var meterService: MeterService

    @Post
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
    fun deleteById(@PathVariable id: Long) {
        meterService.delete(id)
    }
}

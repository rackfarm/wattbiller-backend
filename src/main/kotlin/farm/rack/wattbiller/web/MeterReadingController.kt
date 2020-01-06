package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.MeterReadingDto
import farm.rack.wattbiller.service.MeterReadingService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/meterReading")
class MeterReadingController {
    @Inject
    lateinit var meterReadingService: MeterReadingService

    @Post
    fun createMeterReading(@Body meterReading: MeterReadingDto): MeterReadingDto {
        return meterReadingService.create(meterReading)
    }

    @Get("/all")
    fun readAll(): List<MeterReadingDto> {
        return meterReadingService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): MeterReadingDto {
        return meterReadingService.readById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long) {
        meterReadingService.delete(id)
    }
}

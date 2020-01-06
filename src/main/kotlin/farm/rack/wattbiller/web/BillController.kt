package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.BillDto
import farm.rack.wattbiller.service.BillService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/bill")
class BillController {
    @Inject
    lateinit var billService: BillService

    @Post
    fun createBill(@Body bill: BillDto): BillDto {
        return billService.create(bill)
    }

    @Get("/all")
    fun readAll(): List<BillDto> {
        return billService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): BillDto {
        return billService.readById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long) {
        billService.delete(id)
    }
}

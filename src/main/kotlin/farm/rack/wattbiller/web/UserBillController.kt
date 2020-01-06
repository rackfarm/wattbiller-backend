import farm.rack.wattbiller.model.dto.UserBillDto
import farm.rack.wattbiller.service.UserBillService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/userBill")
class UserBillController {
    @Inject
    lateinit var userBillService: UserBillService

    @Post
    fun createUserBill(@Body userBill: UserBillDto): UserBillDto {
        return userBillService.create(userBill)
    }

    @Get("/all")
    fun readAll(): List<UserBillDto> {
        return userBillService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): UserBillDto {
        return userBillService.readById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long) {
        userBillService.delete(id)
    }
}

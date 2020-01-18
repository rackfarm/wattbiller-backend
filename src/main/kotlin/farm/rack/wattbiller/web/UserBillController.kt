package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.UserBill
import farm.rack.wattbiller.service.UserBillService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/api/userBill")
class UserBillController {
    //    @Inject
    lateinit var userBillService: UserBillService
//
//    @Post
//    fun createUserBill(@Body userBill: UserBillDto): UserBillDto {
//        return userBillService.create(userBill)
//    }

    @Get("/all")
    fun readAll(): List<UserBill> {
        return userBillService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): UserBill {
        return userBillService.readById(id)
    }
//
//    @Delete("/{id}")
//    fun deleteById(@PathVariable id: Long) {
//        userBillService.delete(id)
//    }
}

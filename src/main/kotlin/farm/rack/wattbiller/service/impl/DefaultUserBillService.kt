package farm.rack.wattbiller.service.impl

import farm.rack.wattbiller.jpa.UserBillRepository
import farm.rack.wattbiller.model.UserBill
import farm.rack.wattbiller.service.UserBillService
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityNotFoundException

@Singleton
class DefaultUserBillService @Inject constructor(private val userBillRepository: UserBillRepository,
                                                 private val keycloackUserService: RackfarmKeycloackUserService)
    : UserBillService {

    override fun readById(id: Long): UserBill {
        val username = keycloackUserService.getLoggedInUserOrThrow().username
        val bill = userBillRepository.findById(id).orElseThrow { EntityNotFoundException("Entity with id: $id does not exist") }
        if (username != bill.debitor) {
            throw RuntimeException("Unauthorized")
        }
        return bill
    }

    override fun readAll(): List<UserBill> {
        return userBillRepository.findByDebitor(keycloackUserService.getLoggedInUserOrThrow().username)
    }

}

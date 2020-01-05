package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.UserBill
import farm.rack.wattbiller.model.dto.UserBillDto
import farm.rack.wattbiller.model.dto.UserBillEntryDto
import org.mapstruct.Mapper

@Mapper
interface UserBillMapper {
    fun userBillToUserBillDto(userBill: UserBill): UserBillDto
    fun userBillDtoToUserBill(userBillDto: UserBillDto): UserBill

}

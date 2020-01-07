package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.UserBill
import farm.rack.wattbiller.model.dto.UserBillDto
import farm.rack.wattbiller.model.dto.UserBillEntryDto
import org.mapstruct.Mapper

@Mapper
interface UserBillMapper {
    fun toDto(userBill: UserBill): UserBillDto
    fun toEntity(userBillDto: UserBillDto): UserBill
}

package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.Bill
import farm.rack.wattbiller.model.dto.BillDto
import org.mapstruct.Mapper

@Mapper
interface BillMapper {
    fun billToBillDto(bill: Bill): BillDto
    fun billDtoToBill(billDto: BillDto): Bill
}

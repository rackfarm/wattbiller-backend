package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class UserBill(@Id var id: Long = 0,
                    var periodName: String = "",
                    var debitor: String = "",
                    @OneToMany var entries: List<UserBillEntry> = arrayListOf(),
                    var amount: Double = 0.0)

@Entity
data class MeterCost(@Id var id: Long = 0,
                     var meterName: String = "",
                     var cost: Double = 0.0)

@Entity
data class UserBillEntry(@Id var id: Long = 0,
                         var creditor: String = "",
                         var totalAmount: Double = 0.0,
                         var userBillId: Long = 0,
                         @OneToMany var positions: List<MeterCost> = arrayListOf())

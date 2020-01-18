package farm.rack.wattbiller.model

import javax.persistence.*

@Entity
data class UserBill(@Id var id: Long = 0,
                    @ManyToOne var billingPeriod: BillingPeriod = BillingPeriod(),
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
                         var paymentStatus: PaymentStatus = PaymentStatus.OPEN,
                         @OneToMany var positions: List<MeterCost> = arrayListOf())

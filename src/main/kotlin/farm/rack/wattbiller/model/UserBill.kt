package farm.rack.wattbiller.model

import javax.persistence.*

@Entity
data class UserBill(@Id val id: Long = 0,
                    @ManyToOne val billingPeriod: BillingPeriod = BillingPeriod(),
                    val debitor: String = "",
                    @OneToMany var entries: List<UserBillEntry> = arrayListOf(),
                    val amount: Double = 0.0)

@Entity
data class MeterCost(@Id val id: Long = 0,
                     val meterName: String = "",
                     val cost: Double = 0.0)

@Entity
data class UserBillEntry(@Id val id: Long = 0,
                         val creditor: String = "",
                         val creditorId: String = "",
                         val totalAmount: Double = 0.0,
                         val userBillId: Long = 0,
                         var paymentStatus: PaymentStatus = PaymentStatus.OPEN,
                         @OneToMany val positions: List<MeterCost> = arrayListOf()) {
}

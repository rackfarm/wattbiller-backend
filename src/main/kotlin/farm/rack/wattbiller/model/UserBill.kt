package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class UserBill(@ManyToOne val user: User = User()/*, val billingPeriod: BillingPeriod = BillingPeriod() */) :AbstractEntity() {
}
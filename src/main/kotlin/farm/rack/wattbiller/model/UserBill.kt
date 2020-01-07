package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class UserBill(@ManyToOne val user: User = User(),
                    @ManyToOne val billingPeriod: BillingPeriod = BillingPeriod(),
                    @OneToMany val periodicStatements: List<PeriodicStatement> = arrayListOf()) :AbstractEntity() {
}

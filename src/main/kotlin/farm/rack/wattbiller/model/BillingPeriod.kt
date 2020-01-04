package farm.rack.wattbiller.model

import java.time.LocalDate
import javax.persistence.Entity


@Entity
data class BillingPeriod(val startDate: LocalDate = LocalDate.now(),
                         val endDate: LocalDate = LocalDate.now(),
                         val billed: Boolean = false) : AbstractEntity()
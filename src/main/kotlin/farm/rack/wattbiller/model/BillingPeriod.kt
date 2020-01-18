package farm.rack.wattbiller.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.OneToMany


@Entity
data class BillingPeriod(var name: String = "",
                         var startDate: LocalDate = LocalDate.now(),
                         var endDate: LocalDate = LocalDate.now(),
                         @OneToMany var meterReadings: List<MeterReading> = arrayListOf()) : AbstractEntity()

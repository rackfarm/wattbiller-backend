package farm.rack.wattbiller.model.dto

import java.time.LocalDate

data class PeriodicStatementDto(var id: Long = 0,
                                var amount: Double = 0.0,
                                var meterName: String = "",
                                var meterId: Long = 0,
                                var debitorGroupId: Long = 0,
                                var debitorGroupName: String = "",
                                var periodStartDate: LocalDate = LocalDate.now(),
                                var periodEndDate: LocalDate = LocalDate.now())

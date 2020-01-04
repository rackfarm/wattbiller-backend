package farm.rack.wattbiller.jpa

import farm.rack.wattbiller.model.*
import farm.rack.wattbiller.model.Meter
import farm.rack.wattbiller.model.MeterReading
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import javax.inject.Singleton

@Repository interface UserRepository: CrudRepository<User, String>
@Repository interface MeterRepository: CrudRepository<Meter, Long>
@Repository interface MeterReadingRepository: CrudRepository<MeterReading, Long>
@Repository interface BillRepository: CrudRepository<Bill, Long>
@Repository interface BillingPeriodRepository: CrudRepository<BillingPeriod,Long>
@Repository interface DebitorGroupRepository: CrudRepository<DebitorGroup, Long>
@Repository interface DebitorGroupMembershipRepository: CrudRepository<DebitorGroupMembership, Long>
@Repository interface UserBillRepository: CrudRepository<UserBill, Long>


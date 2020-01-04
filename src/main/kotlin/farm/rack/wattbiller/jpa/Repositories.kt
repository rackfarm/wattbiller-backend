package farm.rack.wattbiller.jpa

import farm.rack.wattbiller.model.*
import farm.rack.wattbiller.model.meter.Meter
import farm.rack.wattbiller.model.meter.MeterReading
import io.micronaut.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, String>
interface MeterRepository: CrudRepository<Meter, Long>
interface MeterReadingRepository: CrudRepository<MeterReading, Long>
interface BillRepository: CrudRepository<Bill, Long>
interface BillingPeriodRepository: CrudRepository<BillingPeriod,Long>
interface DebitorGroupRepository: CrudRepository<DebitorGroup, Long>
interface DebitorGroupMembershipRepository: CrudRepository<DebitorGroupMembership, Long>
interface UserBillRepository: CrudRepository<UserBill, Long>

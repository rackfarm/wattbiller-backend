package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.*
import org.mapstruct.TargetType
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
class EntityReferenceResolver {
    @Inject
    lateinit var entityManager: EntityManager

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var meterRepository: MeterRepository

    fun <T : AbstractEntity> findEntityById(id: Long, @TargetType clazz: Class<T>): T {
        return entityManager.find(clazz, id)
    }

    fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
    }

    fun findMetersByGroupId(id: Long): List<Meter> {
        return meterRepository.findByDebitorGroupId(id)
    }

}

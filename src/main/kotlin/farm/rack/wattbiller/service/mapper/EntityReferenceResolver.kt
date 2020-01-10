package farm.rack.wattbiller.service.mapper

import farm.rack.wattbiller.model.AbstractEntity
import farm.rack.wattbiller.model.dto.Dto
import org.mapstruct.TargetType
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
class EntityReferenceResolver {
    @Inject
    lateinit var entityManager: EntityManager

    fun <T: AbstractEntity> findEntityById(id: Long, @TargetType clazz: Class<T>): T {
        return entityManager.find(clazz, id)
    }
}

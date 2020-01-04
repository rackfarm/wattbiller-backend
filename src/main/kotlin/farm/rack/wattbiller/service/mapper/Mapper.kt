package farm.rack.wattbiller.service.mapper

interface Mapper<Entity, Dto> {
    fun fromDto(dto: Dto): Entity
    fun toDto(entity: Entity): Dto
}
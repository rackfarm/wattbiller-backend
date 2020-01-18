package farm.rack.wattbiller.service

interface CrudService<Dto> : ReadOnlyService<Dto> {

    fun create(dto: Dto): Dto

    fun update(dto: Dto): Dto

    fun delete(id: Long)
}

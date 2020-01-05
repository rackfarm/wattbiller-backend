package farm.rack.wattbiller.service

interface CrudService<Dto> {
    fun create(dto: Dto): Dto

    fun readById(id: Long): Dto

    fun readAll(): List<Dto>

    fun update(dto: Dto): Dto

    fun delete(id: Long): Unit
}

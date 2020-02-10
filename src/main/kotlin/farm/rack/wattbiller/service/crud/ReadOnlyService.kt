package farm.rack.wattbiller.service.crud

interface ReadOnlyService<Dto> {

    fun readById(id: Long): Dto

    fun readAll(): List<Dto>
}

package farm.rack.wattbiller.service

interface ReadOnlyService<Dto> {

    fun readById(id: Long): Dto

    fun readAll(): List<Dto>
}

package farm.rack.wattbiller.service.impl

import farm.rack.wattbiller.exception.EntityNotFoundException
import farm.rack.wattbiller.jpa.MeterRepository
import farm.rack.wattbiller.model.dto.MeterDto
import farm.rack.wattbiller.service.MeterService
import farm.rack.wattbiller.service.mapper.MeterMapper

class DefaultMeterService(private val repository: MeterRepository, private val mapper: MeterMapper) : MeterService {

    private fun save(dto: MeterDto): MeterDto {
        var entity = mapper.toEntity(dto)
        entity = repository.save(entity)
        return mapper.toDto(entity)
    }

    override fun create(dto: MeterDto): MeterDto {
        return save(dto)
    }

    override fun readById(id: Long): MeterDto {
        val entity = repository.findById(id).orElseThrow { EntityNotFoundException("Entity with id: $id does not exist") }
        return mapper.toDto(entity)
    }

    override fun readAll(): List<MeterDto> {
        return repository.findAll().map { mapper.toDto(it) }
    }

    override fun update(dto: MeterDto): MeterDto {
        return save(dto)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

}

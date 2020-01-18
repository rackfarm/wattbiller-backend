package farm.rack.wattbiller.service.impl

import farm.rack.wattbiller.exception.EntityNotFoundException
import farm.rack.wattbiller.jpa.DebitorGroupRepository
import farm.rack.wattbiller.model.dto.DebitorGroupDto
import farm.rack.wattbiller.service.DebitorGroupService
import farm.rack.wattbiller.service.mapper.DebitorGroupMapper

class DefaultDebitorGroupService(private val repository: DebitorGroupRepository, private val mapper: DebitorGroupMapper) : DebitorGroupService {

    private fun save(dto: DebitorGroupDto): DebitorGroupDto {
        var entity = mapper.toEntity(dto)
        entity = repository.save(entity)
        return mapper.toDto(entity)
    }

    override fun create(dto: DebitorGroupDto): DebitorGroupDto {
        return save(dto)
    }

    override fun readById(id: Long): DebitorGroupDto {
        val entity = repository.findById(id).orElseThrow { EntityNotFoundException("Entity with id: $id does not exist") }
        return mapper.toDto(entity)
    }

    override fun readAll(): List<DebitorGroupDto> {
        return repository.findAll().map { mapper.toDto(it) }
    }

    override fun update(dto: DebitorGroupDto): DebitorGroupDto {
        return save(dto)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

}

package farm.rack.wattbiller.service.impl

import farm.rack.wattbiller.exception.EntityNotFoundException
import farm.rack.wattbiller.model.MeterReadingRepository
import farm.rack.wattbiller.model.dto.MeterReadingDto
import farm.rack.wattbiller.service.MeterReadingService
import farm.rack.wattbiller.service.mapper.MeterReadingMapper
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
@Transactional
class DefaultMeterReadingService @Inject constructor(meterReadingMapper: MeterReadingMapper, meterReadingRepository: MeterReadingRepository) : MeterReadingService {

    private val mapper: MeterReadingMapper = meterReadingMapper
    private val repository: MeterReadingRepository = meterReadingRepository

    private fun save(dto: MeterReadingDto): MeterReadingDto {
        var entity = mapper.toEntity(dto)
        entity = repository.save(entity)
        return mapper.toDto(entity)
    }

    override fun create(dto: MeterReadingDto): MeterReadingDto {
        return save(dto)
    }

    override fun readById(id: Long): MeterReadingDto {
        val entity = repository.findById(id).orElseThrow { EntityNotFoundException("Entity with id: $id does not exist") }
        return mapper.toDto(entity)
    }

    override fun readAll(): List<MeterReadingDto> {
        return repository.findAll().map { mapper.toDto(it) }
    }

    override fun update(dto: MeterReadingDto): MeterReadingDto {
        return save(dto)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

}

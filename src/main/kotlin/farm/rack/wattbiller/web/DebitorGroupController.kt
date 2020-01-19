package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.dto.DebitorGroupDto
import farm.rack.wattbiller.service.DebitorGroupService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/debitorGroup")
class DebitorGroupController {

    @Inject
    lateinit var debitorGroupService: DebitorGroupService

    @Post
    fun createDebitorGroup(@Body debitorGroup: DebitorGroupDto): DebitorGroupDto {
        return debitorGroupService.create(debitorGroup)
    }

    @Get("/all")
    fun readAll(): List<DebitorGroupDto> {
        return debitorGroupService.readAll()
    }

    @Get("/{id}")
    fun readById(@PathVariable id: Long): DebitorGroupDto {
        return debitorGroupService.readById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long) {
        debitorGroupService.delete(id)
    }
}

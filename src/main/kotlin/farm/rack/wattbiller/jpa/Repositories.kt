package farm.rack.wattbiller.jpa

import farm.rack.wattbiller.model.User
import io.micronaut.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, String> {
}
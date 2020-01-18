package farm.rack.wattbiller.model

import javax.persistence.*

/**
 * @author Florian Bürgi
 * @since 1.4.0
 */

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long = 0
}

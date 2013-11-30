package orko

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Regalo)
class RegaloSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "los amigos no pueden ser null"() {
        when: 'Alguno de los amigos son null'

        def regalo = new Regalo()
        def regalo1 = new Regalo(amigoFrom: new AmigoInvisible())
        def regalo2 = new Regalo(amigoTo: new AmigoInvisible())

        then: 'la validacion falla'
        !regalo.validate()
        !regalo1.validate()
        !regalo1.validate()

        when: 'cuando ambos amigos no son null'
        regalo = new Regalo(amigoFrom: new AmigoInvisible(),amigoTo: new AmigoInvisible())

        then: 'la validacion es exitosa'
        regalo.validate()
    }
}

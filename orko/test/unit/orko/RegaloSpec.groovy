package orko

import grails.test.mixin.TestFor
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Regalo
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Regalo)
class RegaloSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "los amigos no pueden ser nulos"() {
		given:
		mockForConstraintsTests Regalo
		when: "los atributos son nulos"
		def regalo = new Regalo()
		then: "la validacion falla"
		!regalo.validate()
		regalo.hasErrors()
		regalo.errors['amigoTo'] == 'nullable'
		regalo.errors['amigoFrom'] == 'nullable'
    }
	
	void "los amigos deben tener nombres diferentes"() {
		given:
		mockForConstraintsTests Regalo
		mockForConstraintsTests AmigoInvisible
		when: "si los nombre son iguales"
		def amigoTo = new AmigoInvisible(nombre:"jose")
		def amigoForm = new AmigoInvisible(nombre:"jose")
		def regalo = new Regalo(amigoTo: amigoTo, amigoFrom: amigoForm)
		then: "la validacion falla"
		!regalo.validate()
		regalo.hasErrors()
		regalo.errors['amigoFrom'] == 'validator'
	}
	
	void "los amigos son diferentes"() {
		given:
		mockForConstraintsTests Regalo
		mockForConstraintsTests AmigoInvisible
		when: "si los nombre son iguales"
		def amigoTo = new AmigoInvisible(nombre:"jose")
		def amigoForm = new AmigoInvisible(nombre:"jose1")
		def regalo = new Regalo(amigoTo: amigoTo, amigoFrom: amigoForm)
		then: "la validacion funciona"
		regalo.validate()
		!regalo.hasErrors()
	}
}

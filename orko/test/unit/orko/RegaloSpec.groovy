package orko

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(Regalo)
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

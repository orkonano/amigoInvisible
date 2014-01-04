package orko.dev.amigoInvisible.domain

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Partida)
class PartidaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

   void "validacion de campos vacios"() {
		given:
		mockForConstraintsTests Partida
		when: "los atributos no están cargados"
		def partida = new Partida()
		then: "la validacion falla"
		!partida.validate()
		partida.hasErrors()
		partida.errors['code'] == 'nullable'
		partida.errors['name'] == 'nullable'
    }
   
   void "validacion exitosa"() {
	   given:
	   mockForConstraintsTests Partida
	   when: "se carga los atributos obligatorios"
	   def partida = new Partida(code:"rewwer",name:"flia chimollo")
	   then: "la validacion funciona"
	   partida.validate()
	   !partida.hasErrors()
   }
}

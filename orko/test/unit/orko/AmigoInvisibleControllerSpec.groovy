package orko

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand;
import orko.dev.amigoInvisible.controller.AmigoInvisibleController;
import orko.dev.amigoInvisible.service.AmigoInvisibleService;
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(AmigoInvisibleController)
class AmigoInvisibleControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	void "renderizar cuando tiene error"() {
		given:
			mockForConstraintsTests AmigoInvisibleCommand
			def amigoInvisible = new AmigoInvisibleCommand();
			amigoInvisible.validate()
		when: "Genero la lisata de amigos invisible con error"
			controller.generarAmigoInvisible(amigoInvisible)
		then: "vuelvo al index"
			view == "/amigoInvisible/index"
			model.amigoInvisible != null
			model.amigoInvisible == amigoInvisible
    }
	
	void "renderizar sin error"() {
		given:
			mockForConstraintsTests AmigoInvisibleCommand
			def amigoInvisible = new AmigoInvisibleCommand();
			def serviceMock = Mock(AmigoInvisibleService)
			serviceMock.calcularAmigoInvisible(_) >> { }
			controller.amigoInvisibleService = serviceMock
		when: "Genero la lisata de amigos invisible sin error"
			controller.generarAmigoInvisible(amigoInvisible)
		then: "voy al resultado"
			view == "/amigoInvisible/resultado"
	}
}

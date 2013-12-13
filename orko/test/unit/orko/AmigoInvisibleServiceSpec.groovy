
package orko

import orko.dev.amigoInvisible.domain.AmigoInvisible;
import orko.dev.amigoInvisible.service.AmigoInvisibleService;
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(AmigoInvisibleService)
class AmigoInvisibleServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
    void "test armado de lista debe dar un resultado"() {
		given:
			def listaAmigos = [new AmigoInvisible(nombre:"Mariano",email:"orquito@gmail.com"),new AmigoInvisible(nombre:"Mariano 2",email:"orquito@gmail.com")]
			def amigoService = new AmigoInvisibleService()
		when: "Envio la lista de amigos"
			def regalo = amigoService.calcularAmigoInvisible(listaAmigos)
		then: "veo el resultado obtenido"
			regalo != null
			regalo.size() == listaAmigos.size()
			regalo[0].amigoFrom.nombre == "Mariano"
			regalo[0].amigoTo.nombre == "Mariano 2"
    }
}

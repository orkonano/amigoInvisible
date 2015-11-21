package orko

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import orko.dev.amigoInvisible.command.AmigoInvisibleCommand
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class AmigoInvisibleCommandSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "como minimo tiene que haber dos amigos invisibles"() {
		given:
			mockForConstraintsTests AmigoInvisible
			mockForConstraintsTests Partida
		
		when: "cuando tiene menos de 2 amigos"
		def amigoInvisibleCommand = new AmigoInvisibleCommand()
		then: "la validacion falla"
		!amigoInvisibleCommand.validate()
		amigoInvisibleCommand.hasErrors()
		amigoInvisibleCommand.errors['amigosACalcular'].code == 'minSize.notmet'
		
		when: "cuando tiene menos de 2 amigos"
		amigoInvisibleCommand = new AmigoInvisibleCommand()
		amigoInvisibleCommand.amigosACalcular.add(new AmigoInvisible())
		then: "la validacion falla"
		!amigoInvisibleCommand.validate()
		amigoInvisibleCommand.hasErrors()
		amigoInvisibleCommand.errors['amigosACalcular'].code == 'minSize.notmet'
		
		when: "cuando tiene 2 amigos o mas"
		amigoInvisibleCommand = new AmigoInvisibleCommand(partida: new Partida(code:"hola",name:"char"))
		amigoInvisibleCommand.amigosACalcular.add(new AmigoInvisible(nombre: "pedro",email: "orquito@gmail.com"))
		amigoInvisibleCommand.amigosACalcular.add(new AmigoInvisible(nombre: "Juan",email: "orquito@gmail.com"))
		then: "la validacion funciona"
		amigoInvisibleCommand.validate()
		!amigoInvisibleCommand.hasErrors()
    }
}

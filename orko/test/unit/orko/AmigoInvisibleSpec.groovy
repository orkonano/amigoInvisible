package orko

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(AmigoInvisible)
class AmigoInvisibleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "los atributos no pueden ser null"() {
        when "los atributos son nulos"
        def amigo = new AmigoInvisible()
        then "la validacion falla"
        !amigo.validate()
        amigo.hasErrors()
        amigo.errors['nombre'] == 'nullable'
        amigo.errors['email'] == 'nullable'
    }

    void "los atributos no pueden ser vacios"() {
        when "los atributos son vacios"
        def amigo = new AmigoInvisible(nombre: "",email: "")
        then "la validacion falla"
        !amigo.validate()
        amigo.hasErrors()
        amigo.errors['nombre'] == 'blank'
        amigo.errors['email'] == 'blank'
    }

    void "email sin formato de email"() {
        when "el mail no tiene formato de email"
        def amigo = new AmigoInvisible(nombre: "asd",email: "asdasd")
        then "la validacion falla"
        !amigo.validate()
        amigo.hasErrors()
        amigo.errors['email'] == 'email'
    }

    void "se pasan todas las validacion"() {
        when "ese cargan todos los atributos bien"
        def amigo = new AmigoInvisible(nombre: "asd",email: "orquito@gmail.com")
        then "la validacion anda"
        amigo.validate()
        !amigo.hasErrors()
    }
}

package orko.dev.amigoInvisible.controller

import grails.plugin.springsecurity.annotation.Secured
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Role
import orko.dev.amigoInvisible.domain.User

class PartidaController {

    def springSecurityService

    @Secured(['ROLE_US'])
    def partidas() {
        User user = springSecurityService.getCurrentUser()
        AmigoInvisible amigo = AmigoInvisible.findByUser(user)
        def partidas = Partida.findByParticipante(amigo)
        [partidas: partidas]
    }
}

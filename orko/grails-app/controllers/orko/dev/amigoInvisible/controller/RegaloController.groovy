package orko.dev.amigoInvisible.controller

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Regalo

class RegaloController {

    def springSecurityService

    @Secured(['ROLE_US'])
    def regaloPartida() {
        def partida = Partida.get(params.idPartida)
        def user = springSecurityService.getCurrentUser()
        def amigoFrom = AmigoInvisible.findByUser(user)
        def regalo = Regalo.findByPartidaAndAmigoFrom(partida,amigoFrom)
        [amigoTo:regalo.amigoTo.nombre] as JSON
    }
}

package orko.dev.amigoInvisible.service

import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.Partida

@Transactional
class PartidaService {


    def stringUtils

    def Partida savePartida(Partida partida){
        partida.code = stringUtils.generator((('A'..'Z')+('0'..'9')).join(), 9 )
        partida.save()
        return partida
    }

}

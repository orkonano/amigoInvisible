package orko.dev.amigoInvisible.service

import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Regalo

@Transactional
class RegaloService {

    def serviceMethod() {

    }

    Regalo createRegalo(AmigoInvisible amigoFrom, AmigoInvisible amigoTo, Partida partida) {
        Regalo regalo = new Regalo(amigoFrom: amigoFrom,amigoTo: amigoTo, partida: partida)
        regalo.save()
        return regalo
    }
}

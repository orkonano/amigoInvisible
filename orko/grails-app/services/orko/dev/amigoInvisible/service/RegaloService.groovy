package orko.dev.amigoInvisible.service

import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Regalo

@Transactional
class RegaloService {

    def serviceMethod() {

    }

    List<Regalo> saveRegalos(List<Regalo> regalos) {
        regalos.each {regalo ->
            regalo.save()
        }
        return regalos
    }

}

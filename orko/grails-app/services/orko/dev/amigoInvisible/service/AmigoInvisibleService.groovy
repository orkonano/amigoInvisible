package orko.dev.amigoInvisible.service

import grails.transaction.Transactional
import org.apache.commons.collections.CollectionUtils

import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Regalo

@Transactional
class AmigoInvisibleService {

    def regaloService
    def customSecurityService
	

    def List<Regalo> calcularAmigoInvisible(Partida partida) {
		List<AmigoInvisible> amigosTo = new ArrayList(partida.participantes)
        List<AmigoInvisible> amigosFrom = new ArrayList(partida.participantes)
        Collections.shuffle(amigosTo)
		List<Regalo> regalos = new ArrayList()
		int maxSize = amigosFrom.size()
		int index = 0;
		Random random = new Random()
		while(CollectionUtils.isNotEmpty(amigosTo)){
			AmigoInvisible amigoTo = saveAmigoInvisible amigosTo.get(0), partida
            AmigoInvisible amigoFrom = saveAmigoInvisible amigosFrom.get(index), partida
			if (amigoTo.nombre != amigoFrom.nombre){
				amigosTo.remove(0)
                Regalo regalo = regaloService.createRegalo amigoFrom, amigoTo, partida
				regalos.add(regalo)
				index++
			}else{
				if(amigosTo.size() == 1){
					amigosTo = new ArrayList(amigosFrom)
					index = 0
				} 
				Collections.shuffle(amigosTo)
			}
		}
		return regalos
    }

    def AmigoInvisible saveAmigoInvisible(AmigoInvisible amigo, Partida partida){
        def amigoDB = AmigoInvisible.findByEmail(amigo.email)
        if (!amigoDB){
            def user = customSecurityService.findOrSaveUserByUserName(amigo.email)
            amigo.user = user
            amigo.save()
            amigoDB = amigo
        }else{
            amigoDB.nombre = amigo.nombre
        }
        amigoDB.addToPartidas(partida)
        amigoDB.save()
        return amigoDB
    }
}

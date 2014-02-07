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
        partida = Partida.findById partida.id
		List<AmigoInvisible> amigosTo = new ArrayList(partida.participantes)
        List<AmigoInvisible> amigosFrom = new ArrayList(partida.participantes)
        Collections.shuffle(amigosTo)
		List<Regalo> regalos = new ArrayList()
		int maxSize = amigosFrom.size()
		int index = 0;
		Random random = new Random()
		while(CollectionUtils.isNotEmpty(amigosTo)){
			AmigoInvisible amigoTo = amigosTo.get(0)
            AmigoInvisible amigoFrom = amigosFrom.get(index)
			if (amigoTo.id != amigoFrom.id){
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

    def Partida saveAmigoInvisible(Partida partida){
        List participantes = new ArrayList<AmigoInvisible>(partida.participantes)
        partida.participantes.clear()
        for (amigo in participantes){
            def nombreAux = amigo.nombre
            def email = amigo.email
            amigo = AmigoInvisible.findByEmail(email)
            if (!amigo){
                def user = customSecurityService.findOrSaveUserByUserName(email)
                amigo.user = user
                amigo.email = email
            }
            amigo.nombre = nombreAux
            amigo.addToPartidas(partida)
            amigo.save()
        }
        return partida
    }
}

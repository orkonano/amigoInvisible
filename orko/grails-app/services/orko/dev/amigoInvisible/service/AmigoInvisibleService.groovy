package orko.dev.amigoInvisible.service

import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Regalo

@Transactional
class AmigoInvisibleService {


    def List<Regalo> calcularAmigoInvisible(Partida partida) {
        partida = Partida.findById partida.id
		List<AmigoInvisible> amigosTo = new ArrayList(partida.participantes)
        List<AmigoInvisible> amigosFrom = new ArrayList(partida.participantes)
        Collections.shuffle(amigosTo)
		List<Regalo> regalos = new ArrayList()
		def index
		Random random = new Random()
		while(amigosTo){
            index = random.nextInt(amigosFrom.size())
			AmigoInvisible amigoTo = amigosTo.get(0)
            AmigoInvisible amigoFrom = amigosFrom.get(index)
			if (amigoTo.id != amigoFrom.id){
				amigosTo.remove(0)
                amigosFrom.remove(index)
                Regalo regalo = new Regalo(amigoFrom: amigoFrom,amigoTo: amigoTo, partida: partida)
				regalos.add(regalo)
			}else{
				Collections.shuffle(amigosTo)
			}
		}
		return regalos
    }

    def Partida saveAmigoInvisible(Partida partida){
        List<AmigoInvisible> participantes = new ArrayList<AmigoInvisible>(partida.participantes)
        partida.participantes.clear()
        for (amigo in participantes){
            def nombreAux = amigo.nombre
            def email = amigo.email
            amigo = AmigoInvisible.findByEmail(email)
            if (!amigo){
                amigo = new AmigoInvisible(email: email)
            }
            amigo.nombre = nombreAux
            amigo.addToPartidas(partida)
            amigo.save()
        }
        return partida
    }
}

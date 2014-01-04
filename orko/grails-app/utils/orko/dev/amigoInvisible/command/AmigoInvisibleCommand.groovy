package orko.dev.amigoInvisible.command
import javax.validation.Valid;

import grails.validation.Validateable
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida

@Validateable
class AmigoInvisibleCommand {
	
	Partida partida
	List<AmigoInvisible> amigosACalcular = [].withLazyDefault { new AmigoInvisible() }
	
	static subValidator = {val, obj ->
		return val.validate() ?: 'not.valid'
	}
	
	static constraints = {
		amigosACalcular minSize: 2, validator: { val, obj ->
			if (val.size() > 1)
				for (amigo in val) {
					if (!amigo.validate()){
						return false
					}
				}
				return true
		}
		
		partida(validator:subValidator)
		
	}
}

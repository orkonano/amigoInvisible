package orko
import java.util.List;

import grails.validation.Validateable;

@Validateable
class AmigoInvisibleCommand {
	
	List<AmigoInvisible> amigosACalcular = [].withLazyDefault { new AmigoInvisible() }
	
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
		
	}
}

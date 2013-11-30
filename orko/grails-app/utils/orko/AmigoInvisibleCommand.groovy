package orko
import java.util.List;

import grails.validation.Validateable;

@Validateable
class AmigoInvisibleCommand {
	
	List<AmigoInvisible> amigosACalcular = [].withLazyDefault { new AmigoInvisible() }
}

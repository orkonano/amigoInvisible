package orko

import org.apache.commons.collections.CollectionUtils


class AmigoInvisibleService {
	
	def emailService

    def List<Regalo> calcularAmigoInvisible(List<AmigoInvisible> amigosFrom) {
		List<AmigoInvisible> amigosTo = new ArrayList(amigosFrom);
		Collections.shuffle(amigosTo);
		List<Regalo> regalos = new ArrayList();
		int maxSize = amigosFrom.size();
		int index = 0;
		Random random = new Random()
		while(CollectionUtils.isNotEmpty(amigosTo)){
			AmigoInvisible amigoTo = amigosTo.get(0);
			AmigoInvisible amigoFrom = amigosFrom.get(index);
			if (amigoTo.nombre != amigoFrom.nombre){
				amigosTo.remove(0);
				Regalo regalo = new Regalo(amigoFrom:amigoFrom, amigoTo:amigoTo)
				regalos.add(regalo)
				index++;
			}else{
				if(amigosTo.size() == 1){
					amigosTo = new ArrayList(amigosFrom);
					index = 0;
				} 
				Collections.shuffle(amigosTo);
			}
		}
		
		regalos.each{it -> 
			Regalo regalo = it
			emailService.enviarMailResultado(regalo);
		};
		return regalos
    }
}

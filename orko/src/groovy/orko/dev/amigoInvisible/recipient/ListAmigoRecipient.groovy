package orko.dev.amigoInvisible.recipient

import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida


class ListAmigoRecipient extends Recipient<List<AmigoInvisible>> {

    Partida partida
	
	ListAmigoRecipient(List<AmigoInvisible> lista){
		super(lista)
	}

}

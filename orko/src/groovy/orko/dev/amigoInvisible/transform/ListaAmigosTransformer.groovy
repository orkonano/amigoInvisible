package orko.dev.amigoInvisible.transform



import org.springframework.stereotype.Component

import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Regalo
import orko.dev.amigoInvisible.recipient.ListAmigoRecipient;

@Component
class ListaAmigoTransformer {

	public List<AmigoInvisible> transform(ListAmigoRecipient recipient) {
		if (recipient == null) {
			return null;
		}
	   return recipient.recipient;
	}
}

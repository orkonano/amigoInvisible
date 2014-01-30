package orko.dev.amigoInvisible.transform

import org.springframework.stereotype.Component
import orko.dev.amigoInvisible.domain.AmigoInvisible
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.recipient.ListAmigoRecipient

/**
 * Created by orko on 28/01/14.
 */
@Component
class PartidaTransformer {

    public Partida transform(ListAmigoRecipient recipient) {
        if (recipient == null) {
            return null;
        }
        Partida partida = recipient.partida
        partida.participantes = recipient.recipient
        return partida
    }

}

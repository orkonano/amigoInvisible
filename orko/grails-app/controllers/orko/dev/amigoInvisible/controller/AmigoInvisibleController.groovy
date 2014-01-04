package orko.dev.amigoInvisible.controller

import org.springframework.integration.Message
import org.springframework.integration.support.MessageBuilder

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand
import orko.dev.amigoInvisible.recipient.ListAmigoRecipient



class AmigoInvisibleController {
	
	def appPipelineChannel

    def index() {
		[amigoInvisible: new AmigoInvisibleCommand()] 
    }

    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		if (!amigoInvisibleCommandInstance.hasErrors()){
			ListAmigoRecipient recipient = new ListAmigoRecipient(amigoInvisibleCommandInstance.amigosACalcular);
			Message<ListAmigoRecipient> message = MessageBuilder.withPayload(recipient).build()
			appPipelineChannel.send(message)
			
			render(view:"resultado")
		}else{
			render(view:"index",model:[amigoInvisible: amigoInvisibleCommandInstance])
		}
    }

}

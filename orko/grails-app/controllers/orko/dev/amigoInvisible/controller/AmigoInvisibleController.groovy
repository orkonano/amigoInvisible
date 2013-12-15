package orko.dev.amigoInvisible.controller

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand
import orko.dev.amigoInvisible.domain.Regalo
import orko.dev.amigoInvisible.recipient.ListAmigoRecipient



class AmigoInvisibleController {
	
	def appPipelineGateway

    def index() {
		[amigoInvisible: new AmigoInvisibleCommand()] 
    }

    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		if (!amigoInvisibleCommandInstance.hasErrors()){
			ListAmigoRecipient recipient = new ListAmigoRecipient(amigoInvisibleCommandInstance.amigosACalcular);
			appPipelineGateway.request(recipient)
			render(view:"resultado")
		}else{
			render(view:"index",model:[amigoInvisible: amigoInvisibleCommandInstance])
		}
    }

}

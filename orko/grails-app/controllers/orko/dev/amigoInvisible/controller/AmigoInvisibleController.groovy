package orko.dev.amigoInvisible.controller

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.integration.Message
import org.springframework.integration.support.MessageBuilder

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.recipient.ListAmigoRecipient



class AmigoInvisibleController {
	
	def appPipelineChannel

    @Secured(['permitAll'])
    def index() {
		[amigoInvisible: new AmigoInvisibleCommand(partida:new Partida())] 
    }

    @Secured(['permitAll'])
    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		if (!amigoInvisibleCommandInstance.hasErrors()){
			ListAmigoRecipient recipients = new ListAmigoRecipient(amigoInvisibleCommandInstance.amigosACalcular)
            recipients.partida = amigoInvisibleCommandInstance.partida
			Message<ListAmigoRecipient> message = MessageBuilder.withPayload(recipients).build()
			appPipelineChannel.send(message)
			
			render(view:"resultado",model:[nombrePartida:amigoInvisibleCommandInstance.partida.name])
		}else{
			render(view:"index",model:[amigoInvisible: amigoInvisibleCommandInstance])
		}
    }

}

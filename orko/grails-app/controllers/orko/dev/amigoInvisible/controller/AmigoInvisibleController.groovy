package orko.dev.amigoInvisible.controller

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.integration.Message
import org.springframework.integration.support.MessageBuilder

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand
import orko.dev.amigoInvisible.domain.Partida



class AmigoInvisibleController {
	
	def appSyncChannel

    @Secured(['permitAll'])
    def index() {
		[amigoInvisible: new AmigoInvisibleCommand(partida:new Partida())] 
    }

    @Secured(['permitAll'])
    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		if (!amigoInvisibleCommandInstance.hasErrors()){
            amigoInvisibleCommandInstance.partida.participantes = amigoInvisibleCommandInstance.amigosACalcular
			Message<Partida> message = MessageBuilder.withPayload(amigoInvisibleCommandInstance.partida).build()
			appSyncChannel.send(message)
			
			render(view:"resultado",model:[nombrePartida:amigoInvisibleCommandInstance.partida.name])
		}else{
			render(view:"index",model:[amigoInvisible: amigoInvisibleCommandInstance])
		}
    }

}

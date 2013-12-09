package notificator

import javax.annotation.Resource

import org.springframework.stereotype.Component

import orko.Regalo

class EmailNotificator {

	def mailService

	def enviarMailResultado(Regalo regalo) {
		//		mailGateway.sendMail(regalo);
		mailService.sendMail {
			to regalo.amigoFrom.email
			subject "${regalo.amigoFrom.nombre} tu amigo invisible es...."
			text ".....${regalo.amigoTo.nombre}"
		}
	}

}

package gateways

import org.springframework.integration.router.RecipientListRouter.Recipient

public interface EmailNotificationGateway {
	
	def sendEmail(Recipient recipient)

}

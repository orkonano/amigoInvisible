package transform

import org.springframework.integration.router.RecipientListRouter.Recipient
import org.springframework.mail.MailMessage

class EmailTransformer {

	MailMessage mailMessage;
  
	public MailMessage transform(Recipient recipient) {
		if (recipient == null) {
			return null;
		}
		mailMessage.setTo(recipient.amigoFrom.email);
		mailMessage.setSubject("${recipient.amigoFrom.nombre} tu amigo invisible es....")
		mailMessage.setSentDate(new Date(0));
		mailMessage.setText(".....${recipient.amigoTo.nombre}");
  
	   return mailMessage;
	}
}

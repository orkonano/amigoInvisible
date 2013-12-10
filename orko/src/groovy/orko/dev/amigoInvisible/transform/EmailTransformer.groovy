package orko.dev.amigoInvisible.transform



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage
import org.springframework.stereotype.Component

import orko.dev.amigoInvisible.recipient.RegaloRecipient

@Component
class EmailTransformer {

	MailMessage mailMessage;

	@Autowired
	EmailTransformer(MailMessage mailMessage){
		this.mailMessage = mailMessage
	}
	  
	public MailMessage transform(RegaloRecipient recipient) {
		if (recipient == null) {
			return null;
		}
		mailMessage.setTo(recipient.recipient.amigoFrom.email);
		mailMessage.setSubject("${recipient.recipient.amigoFrom.nombre} tu amigo invisible es....")
		mailMessage.setText(".....${recipient.recipient.amigoTo.nombre}");
  
	   return mailMessage;
	}
}

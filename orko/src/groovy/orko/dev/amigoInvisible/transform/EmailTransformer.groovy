package orko.dev.amigoInvisible.transform



import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailMessage
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Component

import orko.dev.amigoInvisible.domain.Regalo

abstract class EmailTransformer {

	EmailTransformer(){
	}
	  
	public MailMessage transform(Regalo recipient) {
		if (recipient == null) {
			return null;
		}
        def mailMessage = createSimpleMailMessage()
        mailMessage.setTo(recipient.amigoFrom.email);
		mailMessage.setSubject("${recipient.amigoFrom.nombre} tu amigo invisible es....")
		mailMessage.setText(".....${recipient.amigoTo.nombre}");
  
	   return mailMessage;
	}

    public abstract SimpleMailMessage createSimpleMailMessage()
}

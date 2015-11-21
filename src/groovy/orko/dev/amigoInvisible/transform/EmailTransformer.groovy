package orko.dev.amigoInvisible.transform

import org.springframework.mail.MailMessage
import org.springframework.mail.SimpleMailMessage
import orko.dev.amigoInvisible.domain.Regalo
import orko.dev.amigoInvisible.helper.UserRegistrado

abstract class EmailTransformer {

	EmailTransformer(){
	}
	  
	public MailMessage transform(Regalo recipient) {
		if (recipient == null) {
			return null;
		}
        def mailMessage = createSimpleMailMessage()
        mailMessage.setTo(recipient.amigoFrom.email);
        mailMessage.setBcc("orkodevapp@gmail.com")
		mailMessage.setSubject("${recipient.amigoFrom.nombre} tu amigo invisible es....")
		mailMessage.setText(".....${recipient.amigoTo.nombre}");
  
	   return mailMessage;
	}

    public abstract SimpleMailMessage createSimpleMailMessage()


    public MailMessage transformEmailRegistro(UserRegistrado usuarioRegistrado){
        def mailMessage = createSimpleMailMessage()
        mailMessage.setTo(usuarioRegistrado.usuarioRegistrado.username);
        mailMessage.setSubject("Hola ${usuarioRegistrado.usuarioRegistrado.username}, te enviamos tu password de tu amigo invisible")
        mailMessage.setText("Tu password es: ${usuarioRegistrado.uncodePassword}");
        return mailMessage;
    }
}

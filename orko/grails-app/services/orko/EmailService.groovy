package orko

import grails.transaction.Transactional


class EmailService {
	
	def mailService
	def mailGateway;

//		public void doSomethingMethod() {
//	   mailGateway.sendMail(recipient);
//	}

    def enviarMailResultado(Regalo regalo) {
		mailGateway.sendMail(regalo);
		Thread sendEmail = new Thread(new Runnable() {
			public void run() {
				mailService.sendMail {
					to regalo.amigoFrom.email
					subject "${regalo.amigoFrom.nombre} tu amigo invisible es...."
					text ".....${regalo.amigoTo.nombre}"
				}
			}
	   });
	 sendEmail.start();
    }
}

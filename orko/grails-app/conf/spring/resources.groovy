// Place your Spring DSL code here
beans = {
	emailNotificator(notificator.EmailNotificator){
		mailService = ref("mailService")
	}
	mailService(grails.plugin.mail.MailService)
}

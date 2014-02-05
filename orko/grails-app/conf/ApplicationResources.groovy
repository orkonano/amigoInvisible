modules = {
	overrides {
		jquery {
			defaultBundle 'common'
		}
	}
    
	amigoInvisible{
		dependsOn 'mustache'
		defaultBundle 'common'
		
		resource url:'js/amigoInvisible.js'
		
	}
	
	mustache{
		dependsOn 'jquery, bootstrap'
		defaultBundle 'common'
		
		resource url:'js/jquery.mustache.js'
		resource url:'js/mustache.js'
	}
	
	
	application {
		defaultBundle 'common'
		resource url:'js/application.js'
        resource url:'js/login_logout.js'
	}
	
	
	
	
}
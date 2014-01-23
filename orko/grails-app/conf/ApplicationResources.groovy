modules = {
	overrides {
		jquery {
			defaultBundle 'common'
		}
		bootstrap {
			defaultBundle 'common'
		}
	}
    
	amigoInvisible{
		dependsOn 'jquery, mustache, bootstrap'
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
	}
	
	
	
	
}
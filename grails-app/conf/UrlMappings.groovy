class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"amigoInvisible", accion:"index")
        "500"(view:'/error')
	}
}

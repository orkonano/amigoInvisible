package orko.dev.amigoInvisible.domain


class Regalo {

    AmigoInvisible amigoFrom
    AmigoInvisible amigoTo

    static constraints = {
		amigoFrom validator: { val, obj ->
			obj.amigoTo.nombre != val.nombre
		}
	}
}

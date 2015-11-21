package orko.dev.amigoInvisible.domain


class Regalo {

    AmigoInvisible amigoFrom
    AmigoInvisible amigoTo

    Partida partida

    static constraints = {
		amigoFrom validator: { val, obj ->
			obj.amigoTo.nombre != val.nombre
		}
	}
}

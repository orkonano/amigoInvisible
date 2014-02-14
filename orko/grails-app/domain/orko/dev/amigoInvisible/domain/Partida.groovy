package orko.dev.amigoInvisible.domain

class Partida {

	String code
	String name;

	static hasMany = [participantes: AmigoInvisible]
    static belongsTo = [AmigoInvisible,Regalo]

    static constraints = {
		code blank: false
		name blank: false
    }

    static def findByParticipante(AmigoInvisible amigoInvisible) {
        def qPartida = Partida.where {
            participantes{ id == amigoInvisible.id}
        }
        return qPartida.list()
    }
}

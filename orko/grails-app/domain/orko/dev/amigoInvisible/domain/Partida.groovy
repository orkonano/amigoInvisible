package orko.dev.amigoInvisible.domain

class Partida {
	
	String code
	String name;
	List<AmigoInvisible> participantes
	List<Regalo> regalos
	
	static hasMany = [participantes: AmigoInvisible,regalos: Regalo]

    static constraints = {
		code blank: false
		name blank: false
    }
}

package orko.dev.amigoInvisible.domain

class AmigoInvisible {

	String nombre
	String email

    static hasMany = [partidas: Partida]

	static constraints = {
		nombre blank: false
		email email: true, blank: false
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmigoInvisible other = (AmigoInvisible) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}

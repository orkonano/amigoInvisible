package orko.dev.amigoInvisible.domain

class AmigoInvisible {

	String nombre
	String email
    User user

    static hasMany = [partidas: Partida]

	static constraints = {
		nombre blank: false
		email email: true, blank: false
        user nullable: true
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmigoInvisible other = (AmigoInvisible) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

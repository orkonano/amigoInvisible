package orko.dev.amigoInvisible.recipient;

class Recipient<T> {
	
	private T recipient
	
	Recipient(T recipient){
		this.recipient = recipient
	}
	public T getRecipient() {
		return recipient;
	}
	public void setRecipient(T recipient) {
		this.recipient = recipient;
	}

}

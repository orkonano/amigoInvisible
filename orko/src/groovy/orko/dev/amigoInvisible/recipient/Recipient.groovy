package orko.dev.amigoInvisible.recipient;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;

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

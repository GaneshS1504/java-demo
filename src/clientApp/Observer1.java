package clientApp;

public class Observer1 implements Observer {
	
	public String message;
	public Publisher publisher;
	
	public Observer1(String message) {
		super();
		this.message = message;
	}

	@Override
	public void update() {
		String newMessage = (String) publisher.getUpdate(this);
		if(newMessage==null){
			System.out.println(message+":: No new message");
		}else
		System.out.println(message+":: Consuming message::"+newMessage);
	}

	@Override
	public void setNewMessage(Publisher pub) {
		this.publisher = pub;
	}

}

package clientApp;

public class Main {
	
	public static void main(String[] args ) {
		
		Topic topic = new Topic();
		
		Observer obs1 = new Observer1("obs1");
		Observer obs2 = new Observer1("obs2");
		
		topic.register(obs1);
		topic.register(obs2);
		
		obs1.setNewMessage(topic);
		obs2.setNewMessage(topic);
		
		obs1.update();
		
		topic.postMessage("new message");
	}
}

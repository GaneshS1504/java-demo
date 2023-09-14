package clientApp;

public interface Observer {
	
	public void update();
	public void setNewMessage(Publisher pub);
}

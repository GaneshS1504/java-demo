package clientApp;

public interface Publisher {
	public void register(Observer obj);
	public void unregister(Observer obj);
	public Object getUpdate(Observer obj);
	public void notifyObservers();
}

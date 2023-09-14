package clientApp;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Publisher {
	
	String newMessage;
	List<Observer> observers;
	
	
	public Topic() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(Observer obj) {
		if(obj == null) {
			throw new NullPointerException("No Subsribers");
		}
		if(!observers.contains(obj)) {
			this.observers.add(obj);
		}

	}

	@Override
	public void unregister(Observer obj) {
		this.observers.remove(obj);

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.newMessage;
	}
	
	public void postMessage(String message) {
		this.newMessage = message;
		this.notifyObservers();
	}

	@Override
	public void notifyObservers() {
		
		for(Observer ob : this.observers) {
			ob.update();
		}
	}

}

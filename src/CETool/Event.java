package CETool;
import java.util.ArrayList;

public class Event<T> {
	T sender;
	private ArrayList<EventListener<T>> listeners;
	public Event(T sender) {
		listeners = new ArrayList<EventListener<T>>();
		this.sender= sender; 
	}
	public void addListener(EventListener<T> listener) {
		listeners.add(listener);
	}
	public void RemoveListener(EventListener<T> listener) {
		listeners.remove(listener);
	}
	public void DoEvent(int type,Object ...args) {
		for (EventListener<T> eventListener : listeners) {
			eventListener.DoEvent(sender,type,args);
		}
	}
}

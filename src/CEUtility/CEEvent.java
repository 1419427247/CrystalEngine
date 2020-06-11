package CEUtility;
import java.util.ArrayList;

public class CEEvent<T> {
	private ArrayList<CEEventListener<T>> listeners;
	
	public CEEvent() {
		listeners = new ArrayList<CEEventListener<T>>();
	}
	
	public void Add(CEEventListener<T> listener) {
		listeners.add(listener);
	}
	
	public void Remove(CEEventListener<T> listener) {
		listeners.remove(listener);
	}
	
	public void RemoveAll(){
		listeners.clear();
	}
	
	public void DoEvent(T sender,int type,Object ...args) {
		for (CEEventListener<T> eventListener : listeners) {
			eventListener.OnTriggered(sender,type,args);
		}
	}
}

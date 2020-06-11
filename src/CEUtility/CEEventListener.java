package CEUtility;

public interface CEEventListener<T> {
	public void OnTriggered(T sender, int type, Object[] args);
 }

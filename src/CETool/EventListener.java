package CETool;

public interface EventListener<T> {
	public void DoEvent(T sender, int type, Object[] args);
}

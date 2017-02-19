package Notifications;

public interface Notifications {
	
	public void registerNotifications(Observers ob);
	public void unregisterNotifications(Observers ob);
	
	public void notifyObservers();
	public Object getUpdate(Observers ob);

}

package Notifications;

import java.util.List;
import java.util.ArrayList;

public class MyNotifications implements Notifications {
	
	private List <Observers> ob;
	private String message;
	private boolean changed;
	private final Object MUTEX=new Object();
	
	public MyNotifications(){
		this.ob=new ArrayList<>();
	}
	

	@Override
	public void registerNotifications(Observers ob) {
		if(this.ob == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!this.ob.contains(ob)) this.ob.add(ob);
		}
		
	}

	@Override
	public void unregisterNotifications(Observers ob) {
		synchronized (MUTEX) {
			this.ob.remove(ob);
			}
		
	}

	@Override
	public void notifyObservers() {
		List<Observers> obLocal = null;
		
		synchronized (MUTEX) {
			if (!changed)
				return;
			obLocal = new ArrayList<>(this.ob);
			this.changed=false;
		}
		for (Observers ob : obLocal) {
			ob.update();
		}
		
	}

	@Override
	public Object getUpdate(Observers ob) {
		return this.message;
		
	}
	
	public void postNotifications(String msg){
		System.out.println("Notifications Posted:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}


}

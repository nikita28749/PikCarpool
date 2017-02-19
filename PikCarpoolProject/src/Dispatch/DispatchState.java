package Dispatch;

public interface DispatchState {
	
	
	public void requestDispatch();
	public String processDispatch(int fromZip);
	public void completeDispatch();
	
	
	

}

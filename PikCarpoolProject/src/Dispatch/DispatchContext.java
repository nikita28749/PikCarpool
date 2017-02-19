package Dispatch;

public class DispatchContext {
	
	int zipcode;
	
	
	DispatchState requestState;
	DispatchState processState;
	DispatchState completeState;
	DispatchState currentState=new RequestState(this);
	
	
	public DispatchContext(){
		requestState=new RequestState(this);
		processState=new ProcessState(this);
		completeState=new CompleteState(this);
	}
	
	public void requestDispatch() {
		currentState.requestDispatch();
			
			
			
		}

		
		public void processDispatch(int fromZip) {
			currentState.processDispatch(fromZip);
			
		}

		
		public void completeDispatch() {
			currentState.completeDispatch();
			
		}



	public DispatchState getRequestState() {
		return requestState;
	}


	public void setRequestState(DispatchState requestState) {
		this.requestState = requestState;
	}


	public DispatchState getProcessState() {
		return processState;
	}


	public void setProcessState(DispatchState processState) {
		this.processState = processState;
	}


	public DispatchState getCompleteState() {
		return completeState;
	}


	public void setCompleteState(DispatchState completeState) {
		this.completeState = completeState;
	}


	public DispatchState getCurrentState() {
		return currentState;
	}


	public void setCurrentState(DispatchState currentState) {
		this.currentState = currentState;
	}
	
	

}

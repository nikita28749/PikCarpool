package Request;

public class CustomerServiceRequest {
	private String requestType;
    private String action;
	
	enum action{
		Urgent,NonUrgent
	}
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	
	
	CustomerServiceRequest (String request,String action){
		this.action=action;
		this.requestType=request;
		
	}
	
	public String getInformation(){
		if(action.equalsIgnoreCase("Urgent")){
			String query=getRequestType();
			return "Your request is getting attended by the representative currently";
			
			
		}
		else{
			String query=getRequestType();
			return "Your request is in process and will be responsed";
		}
		
	}
	
		
		
	}


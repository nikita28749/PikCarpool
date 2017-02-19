package Routing;

public class RoutingContext {

	RouteStrategy rs;
	
	public float shortestDistance (int to, int from){
		
		int distance =  to - from;
		rs = setRoutingStrategy(distance);
		float shortDistance= rs.route(to, from);
		return shortDistance;
		
		
	}
	
	
public  String setRoutingStrategyType(int to, int from){
	
		
	    int distance = to - from;
		if(distance >10 && distance <= 20){
			return  "Roadway";
		}
		
		if(distance >  20 && distance <= 25){
			return "Highway";
		}
			
			return "Tollway";
		
	}
	
	
	public static RouteStrategy setRoutingStrategy(int distance){
		
		if(distance > 10 && distance <= 20){
			return new Roadway();
		}
		
		if(distance >  20 && distance <= 25){
			return new Highway();
		}
			
	    if(distance>25 && distance<=50){
	    	return new Tollway();
	    }
	    
	    return new Tollway();
		
	}
	
	
}


package Routing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Model.Edge;
import Model.Graph;
import Model.PikAlgorithm;
import Model.Vertex;

public class Highway implements RouteStrategy {
	
	public float route(int to, int from) {
		System.out.println("Highway implemented");
		return (to-from);
	}

	/* private List<Vertex> nodes;
	  private List<Edge> edges;



	@Override
	public float route(int to, int from) {
				  		 
		    nodes = new ArrayList<Vertex>();
		    edges = new ArrayList<Edge>();
		    float mindistance = 0;
		    
		    for (int i = 0; i < 11; i++) {
		      Vertex location = new Vertex("Node_" + i, "Node_" + i);
		      nodes.add(location);
		    }
		    int distance= to-from;
		    addLane("Edge_0", 0, 1, 18);
		    addLane("Edge_1", 0, 2, 21);
		    addLane("Edge_2", 0, 4, 23);
		    addLane("Edge_3", 2, 6, 45);
		    addLane("Edge_4", 2, 7, 13);
		    addLane("Edge_5", 3, 7, 23);
		    addLane("Edge_6", 5, 8, 13);
		    addLane("Edge_7", 8, 9, 84);
		    addLane("Edge_8", 7, 9, 43);
		    addLane("Edge_9", 4, 9, 59);
		    addLane("Edge_10", 9, 10, 14);
		    addLane("Edge_11", 1, 10, 60);

		    // Lets check from location Loc_1 to Loc_10
		    Graph graph = new Graph(nodes, edges);
		    PikAlgorithm dijkstra = new PikAlgorithm(graph);
		    Map<Vertex, Integer> distanceMinimum = dijkstra.execute(nodes.get(0));
		    LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
		      
		    
		    for (Vertex vertex : path) {
		      System.out.println(vertex);
		    }
		    
		    Set mapSet = (Set) distanceMinimum.entrySet();
			Iterator mapIterator = mapSet.iterator();
	        while (mapIterator.hasNext()) 
	        {
	        Map.Entry mapEntry = (Map.Entry) mapIterator.next();
	        String keyValue = (String) mapEntry.getKey();
	         mindistance = (float) mapEntry.getValue();
	        
	        
	        
	        } 
	         
 	 
		
		
		 return mindistance;
}
private void addLane(String laneId, int sourceLocNo, int destLocNo,
	      int duration) {
	    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
	    edges.add(lane);
	  }*/
	
}


import java.util.*;

//Time complexity : O(V+E) V:Vertex and E: edges
public class DetectCycle{
	int V = 7;
	List<List<Integer>> adj;
	
	public DetectCycle(int V){
		adj = new ArrayList();
		for(int i = 0; i< V; i++){
			List<Integer> list = new LinkedList();
			adj.add(list);
		}
	}
	public void addEdge(int source, int dest){
		adj.get(source).add(dest);
	}
	
	public boolean isCycleExist(int i,boolean recStack[],boolean visited[]){
		if(recStack[i]){
			return true;
		}
		if(visited[i]){
			return false;
		}
		System.out.println(i);
		recStack[i] = true;
		visited[i]  = true;
		for(int child:adj.get(i)){
			if(isCycleExist(child,recStack,visited)){
				return true;
			}
		}
		recStack[i] = false;
		return false;
		
	}
	
	public boolean isCycleExistUtil(){
	  boolean recStack[] = new boolean[7];
	  boolean visited []  = new boolean[7];
	  for(int i =0; i<V; i++){
	  	 if(isCycleExist(i,recStack,visited)){
	  	 	return true;
	  	 }
	  }

	return false;
	}
	
	public static void main(String args[]){
		
		DetectCycle detectCycle = new DetectCycle(7);
		detectCycle.addEdge(0,1);
		detectCycle.addEdge(0,2);
		detectCycle.addEdge(2,3);
		detectCycle.addEdge(3,4);
		detectCycle.addEdge(5,1);
		detectCycle.addEdge(5,6);
		//detectCycle.addEdge(6,5);

		
		if(detectCycle.isCycleExistUtil()){
			System.out.println("Cycle exist ");
		}else{
			System.out.println("Cycle doesn't exist");
		}
	}
}
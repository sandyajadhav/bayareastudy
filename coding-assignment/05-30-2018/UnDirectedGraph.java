import java.util.*;


//Time complexity is O(E+V)
public class UnDirectedGraph{
	int v ;
	List<List<Integer>> graph ;
	
	public UnDirectedGraph(int v){
		this.v = v;
		graph = new ArrayList(v);
		for(int i =0; i<v; i++){
		   List<Integer> adj = new LinkedList();
			graph.add(adj);
		}
	}
	
	
	public void addEdge(int u, int v){
		//Undirected graps so add edges for both directions
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	
	public boolean isCycleExistUtils(int i,boolean [] visited,int parent){
		visited[i] = true;
		for(int adj:graph.get(i)){
			if(!visited[adj] ){
				if(isCycleExistUtils(adj,visited,i)){
					return true;
				}
			}else if(adj != parent){
				return true;
			}
		}
	
		return false;
	}
	public boolean isCycleExist(){
	
		boolean [] visited = new boolean[v];
		for(int j = 0; j < v; j++){
			visited[j] = false;
		}
		int parent = -1;
		for(int i = 0; i< v; i++ ){
			if(!visited[i]){
				if(isCycleExistUtils(i,visited,parent)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		UnDirectedGraph udg = new UnDirectedGraph(4);
		udg.addEdge(0,1);
		udg.addEdge(1,2);
		udg.addEdge(0,2);
		udg.addEdge(2,3);
		
		if(udg.isCycleExist()){
			System.out.println("Cycle exists");
		}else{
			System.out.println("Cycle doesn't exist");
		}
		
		
		
	}
	
}
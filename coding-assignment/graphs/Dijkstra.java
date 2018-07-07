public class Dijkstra{
private int V = 4;

	public void findShortestPath(int [][] graph,int source){
		int [] dist = new int[V];
		boolean [] visited = new boolean[V];
		
		for(int i=0; i< V; i++){
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		dist[source] = 0;
		
		for(int count=0; count<V-1; count++){
			int u = minDist(dist,visited);
			visited[u] = true;
			
			for(int v =0; v<V; v++){
				if(!visited[v] && graph[u][v] != 0  && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		
		printShortestPath(dist,source);
		
	}
	
	public int minDist(int []dist,boolean[]visited){
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		for(int i = 0; i < V; i++ ){
			if(!visited[i]){
				if(dist[i] < min){
					min = dist[i];
					min_index = i;
				}
			}
		}
		return min_index;
	}
	
	public void printShortestPath(int [] dist, int source){
		for(int i =0 ; i < dist.length; i++){
			System.out.println((source+1)+" -> "+(i+1)+" = "+dist[i]);
		}
	}
	
	/*
	 1------2
	
	
	*/
	public static void main(String args[]){
		int graph[][] = {{0,1,3,0},
						 {1,0,1,0},
						 {3,1,0,2},
						 {0,0,2,0}	};
						 
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.findShortestPath(graph,2);				 
		
	}

}
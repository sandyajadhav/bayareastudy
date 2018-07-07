public class PrimMST{
	private int V = 4;
	public void mst(int graph[][]){
		int keys[] = new int[V];
		int parent[] = new int[V];
		boolean visited[] = new boolean[V];
		
		for(int i = 0 ; i< V; i++){
			keys[i] = Integer.MAX_VALUE;
			visited[i] = false;
		} 
		
		keys[0] = 0;
		parent[0] = -1;
		
		for(int count = 0; count< V-1; count++){
			//For first iteration this method will return index of source which 0;
			int u = minDist(keys,visited);
			//Mark this node as visited
			visited[u] = true;
			
			//Find minimum distance for all adjacent vertices and update keys array 
			for(int v =0; v< V; v++){
				if(!visited[v] && graph[u][v] != 0 && graph[u][v] < keys[v]){
					parent[v] = u;
					keys[v] = graph[u][v];
				}
			}
		}
		printMst(parent,keys);
		
	}
	
    public void printMst(int parent[], int keys[]){
    	for(int i = 1; i<V; i++){
    		System.out.println(parent[i]+1+" -> "+(i+1)+" = "+keys[i]);
    	}
    }
	
	public int minDist(int keys[], boolean visited[]){
		int min_index = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i< V; i++){
			if(!visited[i]){
				if(keys[i] < min){
					min = keys[i];
					min_index = i;
				}
			}
		}
	
		return min_index;
		
	}
	
	public static void main(String args[]){
		int graph[][] = {{0,1,3,0},
						 {1,0,1,0},
						 {3,1,0,3},
						 {0,0,3,0}	};
						 
		PrimMST primMst = new PrimMST();
		primMst.mst(graph);				 
		
	}
}
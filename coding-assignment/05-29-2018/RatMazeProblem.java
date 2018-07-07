public class RatMazeProblem{
	static int  N = 4;
	
	public boolean solveRatMazeProblem(int [][]matrix,int x, int y,int [][] sol ){
		if( x == N-1 && y == N-1){
			sol[x][y] = 1;
			return true;
		}
		if(isSafeToMove(matrix,x,y)){
		    sol[x][y] = 1;
		    
		    //Now try to find path in y direction
			if(solveRatMazeProblem(matrix,x,y+1,sol)){
				return true;
			}
		
			//Now try to find further path in x direction
			if(solveRatMazeProblem(matrix,x+1,y,sol)){
				return true;
			}
			
			//if there is no path in the both direction then backtrack 
			sol[x][y] = 0;

		}
		return false;
	}
	
	public boolean isSafeToMove(int [][]matrix,int x,int y){
		return (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] == 1);
	}

	public static void main(String args[]){
	
		int matrix[][] ={{1,1,0,0},
	                 	 {0,1,1,1},
	                 	 {0,1,0,0},
	                 	 {0,1,1,1}}; 
	                 	
	    int sol[][]  = new int[4][4];             	
	                 
		RatMazeProblem rateMazeProblem = new RatMazeProblem();
		System.out.println(rateMazeProblem.solveRatMazeProblem(matrix,0,0,sol));
		
		for(int i = 0; i< N; i++){
			for(int j =0; j< N; j++){
				if(sol[i][j] == 1){
					System.out.print(sol[i][j]+" ");
				}else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
	}
}
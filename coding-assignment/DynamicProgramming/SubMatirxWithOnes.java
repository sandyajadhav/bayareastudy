import java.util.*;

public class SubMatirxWithOnes{

	public static int findSquareSubMatixWithOnes(int array[][]){
		int originalArray[][] = cloneArray(array);
		int result =0;
		
		int rowIndex=0,columnIndex=0;
		
		for(int i =0 ; i< array.length; i++){
			for(int j =0; j<array[0].length; j++){
				//do nothing for first row and column
				if(i==0 || j==0){
				
				}else if(array[i][j] == 1){
					//value of item at postion (i,j) will be 1+ minimun value from neighbor (i-1,j-1),(i,j-1),(i-1,j)
					array[i][j] = 1+ Math.min(array[i-1][j-1],Math.min(array[i][j-1],array[i-1][j]));
				}
				if(result < array[i][j]){
					result = array[i][j];
					rowIndex =i;
					columnIndex =j;
			    }
			}
		}
		System.out.println("Row Index = "+rowIndex+"\t column Index="+columnIndex);
		return result;
		
	}
	
	public static int[][] cloneArray(int array[][]){
		int targetArray[][] = new int[array.length][array[0].length];
		
		for(int i=0; i<array.length; i++){
			for(int j=0;j<array[0].length; j++){
				targetArray[i][j] = array[i][j];
			}
		}
		
		return targetArray;
	}

	public static void printMatrix(int array[][]){
		int r=array.length;
		int c= array[0].length;
		
		for(int i=0; i<r; i++){
			for(int j=0; j<c ; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int array[][] = {{0,1,1,0},
						 {0,1,1,1},	
						 {0,1,1,1},	
						 {0,1,1,1}}; 
						 
						 
						 
	    printMatrix(array);
	    
	    System.out.println("Cloned array");
	    printMatrix(cloneArray(array));
	    
	    System.out.println("Size of square sub matrix = "+findSquareSubMatixWithOnes(array));
						 
	}
}
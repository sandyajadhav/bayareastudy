 * 
 * Video link - https://youtu.be/2xvJ41-hsoE
 * 
 * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 * 
 * Maintain a temp array of same size as number of columns. 
 * Copy first row to this temp array and find largest rectangular area
 * for histogram. Then keep adding elements of next row to this temp
 * array if they are not zero. If they are zero then put zero there.
 * Every time calculate max area in histogram.
 * 
 * Time complexity - O(rows*cols)
 * Space complexity - O(cols) - if number of cols is way higher than rows
 * then do this process for rows and not columns.
 * 
 * References:
 * http://www.careercup.com/question?id=6299074475065344
 */

public class MaximumRectangularSubmatrixOf1s{
	MaximumHistogram maximumHistogram = new MaximumHistogram();
	public int getMaximum(int matrix[][]){
		
		int r = matrix.length;
		int c = matrix[0].length;
		int temp[] = new int[matrix[0].length];
		int maxArea =0;
		for(int i=0; i < r; i++){
			for(int j =0 ; j< c; j++){
				
				if(matrix[i][j] == 0){
					temp[j] = 0;
				}else{
					temp[j] = temp[j]+matrix[i][j];
				}
			}
			int area = maximumHistogram.maxHistogram(temp);	
			if(maxArea < area){
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static void main(String args[]){
	
		int matrix[][] ={{0,1,1},
						 {0,0,0},
						 {0,1,1}};
					
		MaximumRectangularSubmatrixOf1s m = new MaximumRectangularSubmatrixOf1s();		
		System.out.println("size of matrix with all 1 is "+m.getMaximum(matrix));		
	}
}
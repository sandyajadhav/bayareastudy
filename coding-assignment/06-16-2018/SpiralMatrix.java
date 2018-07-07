public class SpiralMatrix {
	public void printSpiral(int [][] matrix , int m, int n){
		int l =0;
		int k =0;
		int i;
		while(l< n && k<m){
			
			for(i =l; i< n; i++){
				System.out.println(matrix[k][i]);
			}
			k++;
			
			for(i = k; i<m; i++){
				System.out.println(matrix[i][n-1]);
			}
			n--;
			for( i = n-1; i>=l ; i--){
				System.out.println(matrix[m-1][i]);
			}
			m--;
			
			for( i = m-1; i>=k; i--){
				System.out.println(matrix[i][l]);
			}
			l++;
			
			
		}
		
	}
	
	public static void main(String args[]){
		
		int [][] matrix ={{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		SpiralMatrix s = new SpiralMatrix();
		s.printSpiral(matrix,4,4);
	}
	

}
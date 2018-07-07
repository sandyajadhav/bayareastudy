public class MinimumJump{
	public int getMinimumJump(int array[],int [] result){
		int n = array.length;

		int []jump = new int[n];
		jump[0]  = 0;
		for(int i=1; i<n; i++ ){
			jump[i] = Integer.MAX_VALUE-1;
		}
		
		for(int i = 1 ; i< n; i++){
			for(int j=0; j<i; j++){
				if(array[j]+j >= i){
					if(jump[j] +1 < jump[i] ){
						jump[i] = jump[j] +1;
						result[i] = j;
						//System.out.println(jump[i]);
					}
				}
			}
		}
		return jump[n-1];
	}
	
	public static void main(String args[]){
		MinimumJump m = new MinimumJump();
		int array[] = {1,3,5,3,2,2,6,1,6,8,9};
		int result [] = new int[array.length];
		
		System.out.println("Number of jumps "+m.getMinimumJump(array,result));
		System.out.println("Jumps ");

		for(int i =0; i< array.length; i++){
			System.out.println(result[i]);
		}
	}
}
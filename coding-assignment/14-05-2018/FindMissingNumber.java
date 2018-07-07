public class FindMissingNumber{
	public int getMissingNumberUsingXor(int array[]){
		int n = array.length;
		
		int x1=array[0];
		int x2 =1;
		
		for(int i =1; i<n; i++){
			x1 = x1 ^ array[i];
		}
		
		for(int i = 2; i <= n+1; i++){
			x2 = x2^i;
		}
		
		System.out.println("x1 = "+x1+"\t x2 = "+x2);
		
		return x1^x2;
		
	}
	
	public int getMissingNumber(int array[]){
		int n=array.length;
		//sum = n(n+1)/2
		int total= (n+1)*(n+2)/2;
		
		for(int i=0; i< n ; i++){
			total -=array[i];
		}
		
		return total;
	}
	
	public static void main(String args[]){
	
	     //Time complexity is O(n)
	 	int array[] = {6,2,1,4,5,7,8};
	 
		 FindMissingNumber findMissingNumber = new FindMissingNumber();
	 	System.out.println("Missing number is "+findMissingNumber.getMissingNumber(array));
	 		 	System.out.println("Missing number using xor is "+findMissingNumber.getMissingNumberUsingXor(array));

			
	}
}
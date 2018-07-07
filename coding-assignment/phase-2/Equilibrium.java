public class Equilibrium{

    public static void printEquilibriumIndex(int array[]){
    	
    	for(int i = 0; i < array.length; i++){
    		
    		int leftSum = 0;
    		for(int j =0; j<i; j++){
    			leftSum += array[j];
    		}
    		
    		int rightSum = 0;
    		for(int j = i+1; j< array.length; j++){
    			rightSum += array[j];
    		}
    		
    		if(rightSum == leftSum){
    		 System.out.println(i);
    		}
    	}
    	
    }
    
        public static void printEquilibriumIndex1(int array[]){
			
			int sum = 0;
			for(int i =0 ; i < array.length; i++){
				sum+=array[i];
			}
			
			int leftSum =0,rightSum =sum;
			
			for(int j=0; j<array.length; j++){
			    
			    rightSum = rightSum-array[j];

			    if(rightSum == leftSum){
			    	System.out.println(j);
			    }
			    
			    leftSum += array[j]; 
			}
			
		}
	public static void main(String args[]){
		int array[] = {-7,1,5,2,-4,3,0};
		printEquilibriumIndex1(array);
	
	}

}
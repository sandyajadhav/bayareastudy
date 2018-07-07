import java.util.*;
public class ZeroSumSubarray{
     

	public static boolean isSubArrayExistWithSumZero(int array[]){
		
		Map<Integer,Boolean> sumMap = new HashMap();
		
		int sum = 0;
		for(int i =0; i< array.length; i++){
		    if(array[i] == 0 ){
		    	return true;
		    }
			sum += array[i];
			if(sum ==0 || sumMap.get(sum)!=null){
				return true;
			}
			sumMap.put(sum,true);
		}
		
		return false;
		
	}

	public static void main(String args[]){
	
	 int array[] = {-3, -2, 3, 2, 6};
	 
	 System.out.println(isSubArrayExistWithSumZero(array));
		
	}

}
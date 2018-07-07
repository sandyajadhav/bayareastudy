import java.util.*;

public class SubArraySum{

public static int [] subArraySum(int array[],int sum){
	
	int start = 0;
	int currentSum = array[0];
	int subArray[] = null;

	
	for(int i =1; i <= array.length; i++){
		
		//star subtracting items from left currentSum > sum
		//and at least there should be one item start < i-1
		while(currentSum > sum && start < i-1){
			currentSum = currentSum - array[start];
			start++;
		
		}
		
		if(currentSum == sum){
			subArray = Arrays.copyOfRange(array,start,i);
			System.out.println("sub array from index "+start+" to index "+(i-1));
			return subArray;
		}

        if(i<array.length)
			currentSum = currentSum	+ array[i];
	}
	
	return subArray;
	
	
}

	public static void main(String args[]){
		int array[] = {23,3,32,4,6,5,10};
		
		int subArray[] = subArraySum(array,21);
		
		for(int i =0; i< subArray.length; i++){
			System.out.println(subArray[i]);
		}
		

	}


}
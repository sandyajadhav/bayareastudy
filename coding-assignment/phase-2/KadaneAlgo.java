import java.util.*;

public class KadaneAlgo{
	public static int getMaxSubArraySum(int array[]){
		int maxSum=array[0];
		int currentSum = array[0];
		
		for(int i =1; i < array.length; i++){
			currentSum = Math.max(array[i],currentSum+array[i]);
			maxSum = Math.max(currentSum,maxSum);
			
		}
		
		return maxSum;
		
	}


	public static void main(String args[]){
		int array[] = {1,17,-2,-1,3,-14,-1,4,16};
		System.out.println(getMaxSubArraySum(array));
	}
}
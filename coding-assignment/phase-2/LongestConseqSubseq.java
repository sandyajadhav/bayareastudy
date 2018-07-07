import java.util.*;

public class LongestConseqSubseq{

	public static int findLongestConseqSubseq(int array[]){
		
		Set<Integer> set = new HashSet();
		for(int i =0 ; i < array.length; i++){
			set.add(array[i]);
		}
		
		int longestSequence = 0;
		
		for(int i=0 ; i < array.length; i++){
			if(!set.contains(array[i]-1)){
				
				int j = array[i];
				while(set.contains(j)){
					j++;
				}
				
				if(longestSequence < j-array[i]){
					longestSequence = j-array[i];
				}
			}
		}
		
		return longestSequence;
	
	}
	public static void main(String args[]){
		
		int array[] = {12,1,3,2,66,4,6,8,7,10,9,11};
		
		System.out.println("Longest consecutive sequence in array "+findLongestConseqSubseq(array));
	}
}
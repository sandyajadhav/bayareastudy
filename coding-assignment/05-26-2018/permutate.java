import java.util.*;
public class StringPermutate{
	public void permutate(char str[], int count[], char result[], int level){
		if(level == str.length){
			printArray(result);
		}
		
		for(int i =0; i< str.length; i++){
			if(count[i] != 0){
				result[level] == str[i];
				count[i]--;
				permutate(str,count,result,level+1);
				count[i]++;
			}
		}
	}
	
	
	public void printArray(char array[]){
		for(int i =0; i< array.length; i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	public static void main(String args[]){
		String str = "ABC";
		
		Map<Character, Integer> countMap = new HashMap();
		
		for(int i =0 ;i < str.length(); i++){
			Character character = str.charAt(i);
			if(countMap.containsKey(character)){
				Integer count = countMap.get(character);
				countMap.put(character,count++);
			}else{
				countMap(character,1);
			} 
		}
		
		int char[] strArray = new char[countMap.size()];
		int int[] countArray = new int[countMap.size()];

		for(Map.Entry<Character,Integer> entry: countMap.entrySet()){
			strArray.add(entry.key());
			countArray.add(entry.value());
		}
	}

} 
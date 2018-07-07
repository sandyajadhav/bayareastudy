import java.util.*;
public class StringPermutate{
	
	public void permutate(String str){
		Map<Character, Integer> countMap = new HashMap();
		
		for(int i =0 ;i < str.length(); i++){
			Character character = str.charAt(i);
			if(countMap.containsKey(character)){
				Integer count = countMap.get(character);
				
				countMap.put(character,++count);
			}else{
				countMap.put(character,1);
			} 
		}
		
		 char[] strArray = new char[countMap.size()];
		 int[] countArray = new int[countMap.size()];

		int i =0;
		for(Map.Entry<Character,Integer> entry: countMap.entrySet()){
			strArray[i] = entry.getKey();
			countArray[i] = entry.getValue();
			//System.out.println(entry.getKey()+" "+entry.getValue());
			i++;
		}
		
		char result [] = new char[str.length()];
		
		//printArray(strArray);
		//printArray(countArray);
		permutateUtil(strArray,countArray,result,0);
	}
	public void permutateUtil(char str[], int count[], char result[], int level){
		if(level == result.length){
			printArray(result);
			return ;
		}
		
		for(int i =0; i< str.length; i++){
			if(count[i] == 0){
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permutateUtil(str,count,result,level+1);
			count[i]++;
		}
	}
	
	
	public void printArray(char array[]){
		for(int i =0; i< array.length; i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	public static void main(String args[]){
		String str = "AABC";
		StringPermutate s = new StringPermutate();
		s.permutate(str);
	}

} 
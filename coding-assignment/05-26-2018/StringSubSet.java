import java.math.*;
import java.util.*;
public class StringSubSet{
	
	public Set<String> getSubSet(String string){
		
		char [] array = string.toCharArray();
		
		int n = array.length;
		
		int possibleCombination = (int)Math.pow(2,n);
		Set<String> result = new HashSet();
		for(int i =1; i< possibleCombination; i++){
			String str = "";
			for(int j =0; j<n; j++){
				if(BigInteger.valueOf(i).testBit(j)){
					str=str+array[j];
				}
			}
			//if(!result.contains(str)){
				result.add(str);
			//}
		}
		
		return result;
		
	}
	
	public static void main(String args[]){
		StringSubSet stringSubSet = new StringSubSet();
		String str = args[0];
		
		stringSubSet.getSubSet(str).forEach(p->System.out.println(p));
		
	}
}
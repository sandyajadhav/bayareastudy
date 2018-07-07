import java.util.*;
public class SortByFrequency{

	public void sort(int array[]){
		Map<Integer, Integer> map = new HashMap();
		
		for(int i =0 ; i< array.length; i++){
			if(map.containsKey(array[i])){
				int count = map.get(array[i]);
				count++;
				map.put(array[i],count);
			}else{
				map.put(array[i],1);
			}
		}
		
		ValueComparator valueComparator = new ValueComparator(map);
		TreeMap<Integer, Integer> sortMap = new TreeMap(valueComparator);		
		sortMap.putAll(map);
		int i =0;
		for(Map.Entry<Integer, Integer> entry:sortMap.entrySet()){
			System.out.println(entry.getKey()+","+entry.getValue());
			for(int j=0; j<entry.getValue(); j++){
			   array[i] = entry.getKey();
			   i++;
			}
			
		}
		
		
	}
	public static void main(String args[]){
		int array[] = {8,8,1,2,1,1,2,2,2,3,3,4,6,7,7,7,7,5,5};
		SortByFrequency s = new SortByFrequency();
		s.sort(array);
		printArray(array);
		
		
	}
	
	public static void printArray(int array[]){
		for(int i =0; i< array.length; i++){
			System.out.println(array[i]);
		}
	}
	
}

class ValueComparator implements Comparator<Integer>{
	private Map<Integer ,Integer> map;
	public ValueComparator(Map<Integer ,Integer> map){
		this.map = map;
	}
	
	public int compare(Integer obj1,Integer obj2){
	  if(map.get(obj1) <= map.get(obj2) ){
	  	return -1;
	  } else {
	  	return 1;
	  }
	}
}
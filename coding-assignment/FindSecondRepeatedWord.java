import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class FindSecondRepeatedWord{

    public static void main(String args[]) throws Exception{
        String line ;
        Map<String,Integer> wordCountMap = new HashMap<>();

        File file = new File("data.txt");
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        while((line = bufferReader.readLine()) != null){
        	String words[] = line.split(" ");

        	for(String word: words){
            	if(wordCountMap.containsKey(word)){
                	int count = wordCountMap.get(word);
                	wordCountMap.put(word,++count);
            	}else{
                	wordCountMap.put(word,1);
            	}
        	}
        }
        
        for(Map.Entry<String,Integer> entry:wordCountMap.entrySet()){
        	System.out.println(entry.getKey()+" = "+ entry.getValue());
        }

        Integer array[] = wordCountMap.values().toArray(new Integer[]{});
        int secondLargestItem = getSecondLargestItem(array);
	
        for(Map.Entry<String,Integer> entry:wordCountMap.entrySet()){
            if(entry.getValue() == secondLargestItem){
                System.out.println(entry.getKey());
                break;
            }
        }

    }

    public static int getSecondLargestItem(Integer array[]){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i =0; i<array.length; i++ ){
            if(first < array[i]){
                second = first;
                first = array[i];
            }else if(second  < array[i] && first != array[i]){
                second = array[i];
            }
        }

        return second;

    }
    
}
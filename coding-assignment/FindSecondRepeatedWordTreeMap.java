import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class FindSecondRepeatedWordTreeMap{

    public static void main(String args[]) throws Exception{
        String line ;
        Map<String,Integer> wordCountMap = new TreeMap<>();

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
    
}
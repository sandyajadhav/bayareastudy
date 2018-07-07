import java.util.*;

public class FindKthLargestNumber{
   public int getKthLargestNumber(int array[],int low, int high, int k){
   	 if(low <= high){
   	 	int pivot = partition(array,low,high);
   	 	if(pivot == k){
   	 		return array[pivot];
   	 	}
   	 	
   	 	if(k < pivot){
   	 		return getKthLargestNumber(array,low,pivot-1,k);
   	 	}else{
   	 		return getKthLargestNumber(array,pivot+1,high,k);
   	 	}
   	 }
   	 
   	 return 0;
   
   }
   
   public int partition(int array[],int low,int high){
   		int pivot = array[high];
   		int i = low-1;
   		int j = low;
   		while(j < high){
   			if(array[j]>= pivot){
   				i++;
   				swap(array,i,j);
   			}
   			j++;
   		}	
   		
   	    swap(array, i+1,high);
   	    return i+1;
   }
   
   public void swap(int array[],int i, int j){
   		int temp = array[i];
   		array[i] = array[j];
   		array[j] = temp;
   }


    public int getKthLargestNumber(List<Integer> list,int k){
       	Collections.sort(list,Collections.reverseOrder());
		return list.get(k);
    }
    
     public int getKthLargestNumber(int array[],int k){
       	Arrays.sort(array);
		return array[array.length-1-k];
    }
	public static void main(String args[]){
		 List<Integer> list = Arrays.asList(10,34,34,34,23,1,1,5,67);
		FindKthLargestNumber f = new FindKthLargestNumber();
		int k = 3;
		System.out.println(f.getKthLargestNumber(list,k-1));
		
		int [] array = {10,34,34,34,23,1,1,5,67};
		System.out.println(f.getKthLargestNumber(array,k-1));
		
	   System.out.println(k+" th largest using quick select "+f.getKthLargestNumber(array,0,array.length-1,k-1));
	   
	   for(int i =0 ; i < array.length; i++){
	   		System.out.println(array[i]);
	   }


	}
}
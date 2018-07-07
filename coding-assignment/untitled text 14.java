public class FindKthSmallestNumber{
	public static void main(String args[]){
		
		int array[] = {2,20,5,4,11,15};
		
		sort(array,0,array.length-1);
		System.out.println(getSmallest(array,0,array.length-1,2));
		
		
	}
	
	public static int getSmallest(int array[],int left,int right,int k){
	
		if(left < right){
			int pivot = partition(array,left,right);
			
			if(k == pivot){
			 return k;
			}
			if(k < pivot){
				return getSmallest(array,left,pivot-1,k);
			}else{
				return getSmallest(array,pivot+1, right,k); 
			}
	
		}
	}
	
	public static int partition(int array[],int left,int right){
		int pivot = array[right];
	
		int i =left-1;
		int j=left;
	
		while(j < right){
	
			if(array[j] <= pivot){
			
			i++;
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			
			}
			j++;
		}
		
		int temp = array[i+1];
		array[i+1] = array[right];
		array[right] = temp;
		return i+1; 
	
	}
}
public class QuickSort{
	public static void main(String args[]){
		
		int array[] = {2,20,5,4,11,15};
		
		sort(array,0,array.length-1);
		
		for(int i =0 ; i< array.length; i++){
			System.out.println(array[i]);
		}
		
	}
	
	public static void sort(int array[],int left,int right){
	
		if(left < right){
			int pivot = partition(array,left,right);
			
			sort(array,left,pivot-1);
			sort(array,pivot+1, right); 
	
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
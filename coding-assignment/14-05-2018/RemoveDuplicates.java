public class RemoveDuplicates{

	public static int removeDuplicates(int array[]){
		int j=0;
		for(int i =0; i< array.length-1; i++){
			if(array[i] !=  array[i+1]){
				array[j] = array[i];
				j++;
			}
		}
		array[j] = array[array.length-1];
		
		return j;
	}
	
	
	public static void main(String args[]){
		
		int array[] = {1,1,2,2,3,4,5,6,7};
		
		int newSize = removeDuplicates(array);
		
		for(int i =0; i < newSize; i++){
			System.out.println(array[i]);
		}
		
	}
}
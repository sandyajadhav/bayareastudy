public class PrintDuplicates{

	public static void printDuplicateNumber(int array[]){
		
		for(int i=0; i< array.length; i++){
			
			if(array[Math.abs(array[i])] >=0){
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			}else{
				System.out.println(Math.abs(array[i]));
			}
		}
	}
	public static void main(String args[]){
		int array[] = {1,2,1,2,3,4,5,5,6};
		printDuplicateNumber(array);
	}
}
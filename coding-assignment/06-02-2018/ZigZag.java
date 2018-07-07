//Naiv solution is to first sort and then except first swap all other items	
public class ZigZag{
	//Time complexity (Linear): O(N)
	//Space Complexity (Constant): O(1)
	public void convertArrayToZigZag(int arr[]){
		boolean flag = true;
		
		for(int i = 0; i < arr.length-1; i++){
			if(flag){
				if(arr[i] < arr[i+1]){
					swap(arr,i,i+1);
				}
			}else{
				if(arr[i+1] < arr[i]){
					swap(arr,i,i+1);
				}
			}
			flag = !flag;
		}
	}
	
	public void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void printArray(int arr[]){
		for(int i =0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6,7,8,9};
		
		ZigZag zigZag = new ZigZag();
		zigZag.convertArrayToZigZag(arr);
		zigZag.printArray(arr);
	}	
	
}
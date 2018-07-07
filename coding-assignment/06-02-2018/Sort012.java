public class Sort012{

	//Time complexity (Linear): O(N)
	//Space Complexity (Constant): O(1)
	public void sort(int arr[]){
		if(arr == null || arr.length == 0){
			return;
		}
		
		int low = 0;
		int high = arr.length-1;
		int index =0;
		int temp;
		
		while(index <= high){
			switch(arr[index]){
				case 0:
					swap(arr,index,low);
					low++;
					index++;
					break;
			    case 1:
			    	index++;
			    	break;
			    case 2:
			    	swap(arr,index,high);
			    	high--;
			    	break;			
			}
		}
	}
	
	public void sort1(int arr[]){
		int count0, count1, count2;
		count0= count1= count2=0;
		
		for(int i = 0; i< arr.length; i++){
			if(arr[i] == 0)
				count0++;
			else if(arr[i] == 1)
				count1++;
			else
				count2++;		
		}
		for(int i = 0; i < count0; i++ ){
			arr[i] = 0;
		}
		
		for(int i = 0; i < count1; i++ ){
			arr[count0-1+i] = 1;
		}
		
		for(int i = 0; i < count1; i++ ){
			arr[count0+count1-1+i] = 2;
		}
		
	}
	
	public void printArray(int arr[]){
		for(int i =0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String args[]){
		int arr[] = {2,0,1,1,0,0,0,1,1,2,2,0,2};
		
		Sort012 sort = new Sort012();
		sort.sort1(arr);
		sort.printArray(arr);
	}
}
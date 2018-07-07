public class ChocolateDistribution{
	public int getMinDiff(int arr[],int n, int m){
		QuickSort.sort(arr,0,n-1);
		int minDiff = Integer.MAX_VALUE;
		int first =0;
		int last = m-1;
		for(int i =0; i+m-1< n; i++){
			int diff = arr[i+m-1] - arr[i];
			if(diff < minDiff){
				minDiff = diff;
				first = i;
				last = i+m-1;
			}
		}
		
		System.out.println("Small packet"+arr[first]+" Large packet "+arr[last]);

		return minDiff;
	}
	
	public static void main(String args[]){
		int arr[] = {6,8,2,5,10,13,1,3,18,30};
		ChocolateDistribution c = new ChocolateDistribution();
		System.out.println("Mininum diff "+c.getMinDiff(arr,arr.length,6));
	}
}  

class QuickSort{
	
	public static void sort(int arr[],int left,int right){
		if(left < right){
			int pivot = partition(arr,left,right);
			sort(arr,left,pivot-1);
			sort(arr,pivot+1,right);
		}
	}
	
	private static int partition(int arr[],int left, int right){
	
		int pivot = arr[right];
		int i = left -1;
		int j = left;
		while(j< right){
			if(arr[j] <= pivot){
				i++;
				swap(arr,i,j);
			}
			j++;
		}
       swap(arr,i+1,right);
       return i+1;		

	}
	
	private static void swap(int arr[],int i, int j){
		int temp = arr[i];
		arr[i]  = arr[j];
		arr[j] = temp;
	}
}
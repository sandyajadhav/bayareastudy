public class PythagoreanTriplet{

	public void printPythagoreanTriplet(int arr[], int n){
		
		for(int i = 0 ; i< n; i++){
			for(int j = i+1; j< n; j++ ){
				for(int k = j+1; k< n; k++){
					int x = arr[i]*arr[i];
					int y = arr[j]*arr[j];
					int z = arr[k]*arr[k];
					
					if((x == y + z) || (y == x + z) || (z == x + y)){
						System.out.println("pythagorean triplet "+arr[i]+","+arr[j]+","+arr[k]);
					}
				}
			}
		}
	
	}
	//O(n^2);
	public void printPythagoreanTriplet1(int arr[],int n){
		QuickSort.sort(arr,0,n-1);
		
		for(int i =0 ; i< n; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for(int i = 0 ; i< n; i++){
			int x = arr[i]*arr[i];
			int l = i+1;
			int r = n-1;
			while(l<r){
				int y = arr[l]*arr[l];
				int z = arr[r]*arr[r];
				if((x == y + z) || (y == x + z) || (z == x + y)){
						System.out.println("pythagorean triplet "+arr[i]+","+arr[l]+","+arr[r]);
				}
				
				if(y+z > x){
					r--;
				}else{
					l++;
				}
				
			}
			
		}
	}
	
	public static void main(String args[]){
		int arr[] = {33,22,4,3,56,9,2,1,7,5};
		PythagoreanTriplet p = new PythagoreanTriplet();
		p.printPythagoreanTriplet1(arr, arr.length);
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
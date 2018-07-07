import java.util.*;

//Time Complexity: O(n)
//Auxiliary Space: O(n)
public class TrappingRainWater{
	public int getRainWater(int arr[],int n){
		int left[] = new int[n];
		int right[] = new int[n];
		
		left[0] = arr[0];
		for(int i = 1; i<n; i++){
		    left[i] = Math.max(left[i-1],arr[i]);
		}
		
		right[n-1] = arr[n-1];;
		for(int i = n-2; i>=0; i--){
			right[i] = Math.max(right[i+1],arr[i]);
		}
		int water =0;
		for(int j=0; j< n; j++){
			water = water + Math.min(left[j],right[j])-arr[j];
		}
		return water;
	}
	
	public static void main(String args[]){
		int arr[] = {3,0,0,1,0,4};
		TrappingRainWater t = new TrappingRainWater();
		System.out.println(t.getRainWater(arr,arr.length));
	}
	
}	
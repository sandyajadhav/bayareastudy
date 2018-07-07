public class Permutation{
	public void permutate(String str,int l, int r){
		if(l==r){
			System.out.println(str);
		}
		
		for(int i =l ; i<r; i++){
			str = swap(str,l,i);
			permutate(str,l+1,r);
			str = swap(str,l,i);
		}
	}
	
	public String swap(String str,int l,int i){
		char [] array = str.toCharArray();
		
		char temp = str.charAt(l);
		array[l] = array[i];
		array[i] = temp;
		return new String(array);
	}
	public static void main(String args[]){
		Permutation permutation = new Permutation();
		permutation.permutate("ABC",0,3);
		
		int [] array = {1,2,3};
		permutation.permutate(array,0,3);

		
	}
	
	public void permutate(int [] array,int l, int r){
		if(l==r){
			for(int i =0; i< array.length; i++){
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}
		
		for(int i =l ; i<r; i++){
			array = swap(array,l,i);
			permutate(array,l+1,r);
			array = swap(array,l,i);
		}
	}
	
	
	public int [] swap(int [] array,int l,int i){
		
		int temp = array[l];
		array[l] = array[i];
		array[i] = temp;
		return array;
	}
}
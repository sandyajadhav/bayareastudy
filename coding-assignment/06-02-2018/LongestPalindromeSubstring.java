public class LongestPalindromeSubstring{
	public int getLongestPalindromeSubstring(String str){
		if(str == null){
			return 0;
		}
		int n = str.length();
		if(n == 1){
			return 1;
		}
		 
		boolean [][]T = new boolean[n][n];
		int maxLength = 0;
		for(int i =0; i<n ;i++){
			T[i][i] = true;
			maxLength = 1;
		}
		
		for(int i=0; i<n-1; i++ ){
			if(str.charAt(i) == str.charAt(i+1)){
				T[i][i+1] = true;
				maxLength = 2;
			}
		}
		
		
		for(int k = 3; k<=n; k++){
			
			for(int  i =0; i<n-k+1; i++){
				int j = i+k-1;
				if(str.charAt(i) == str.charAt(j) && T[i+1][j-1]){
				    T[i][j] = true;
					if(k > maxLength){
						maxLength = k;
						
					}
				}
				
				
			}
		}
		
		return maxLength;
		
	}
	
	public static void main(String args[]){
	
		LongestPalindromeSubstring l = new LongestPalindromeSubstring();
		
		System.out.println(l.getLongestPalindromeSubstring("abccccdd"));
	}
}
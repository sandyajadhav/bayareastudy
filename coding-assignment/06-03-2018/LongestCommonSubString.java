import java.util.*;
//Time Complexity: O(m*n)
//Auxiliary Space: O(m*n)
public class LongestCommonSubString{
	public int getLengthOfLCS(char X[] , char Y[] ){
		int n = X.length;
		int m = Y.length;
		
		
		int LCS[][] = new int[n+1][m+1];
		int result = 0;
		for(int i = 0; i<=n; i++){
			for(int j = 0; j <= m; j++){
				if(i == 0 || j == 0){
					LCS[i][j] = 0; 
				}else if(X[i-1] == Y[j-1]){
					LCS[i][j] = LCS[i-1][j-1] + 1;
					result = Math.max(LCS[i][j],result);
				}else{
					LCS[i][j] = 0;
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        LongestCommonSubString lcs = new LongestCommonSubString();
        System.out.println("Length of Longest Common Substring is "
                + lcs.getLengthOfLCS(X.toCharArray(), Y.toCharArray()));
        
	}
}
public class AnagramStrings{

	public static boolean areAnagramStrings(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		int count[] = new int[256];
		
		for(int i=0; i< str1.length(); i++){
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;

		}
		
		for(int i=0; i< str1.length(); i++){
			if(count[str1.charAt(i)] != 0){
				return false;
			}
		}
	 	return true;	
	}
 public static void main(String args[]){
 
 	String str1= "geeksforgeeks";
 	String str2 = "forgeeksgeeks";
 	System.out.println(areAnagramStrings(str1,str2));
 	
 }
}
public class PatternMatch{

boolean expMatch(String string, String p){
	
	if(!string.contains("*") && string.length() != p.length()){
		return false;
	}
    for(int i=0,j=0; i<string.length(); i++){
        Character char1 = string.charAt(i);
        Character char2 = p.charAt(j);

        if(char1 == char2){
        	j++;
            continue;
        }else if(char1 != char2  && char2 == '.' ){
        	j++;
            continue;
        }else if(char1 != char2  && char2 == '*' ){
            continue;
        }else{
        	return false;
        }
    }
    return true;
}


	public static void main(String args[]){
		String str1 ="VVV";
		String str2 = "VV*V";
		PatternMatch patternMatch = new PatternMatch();
		System.out.println(patternMatch.expMatch(str1,str2));
	}
}
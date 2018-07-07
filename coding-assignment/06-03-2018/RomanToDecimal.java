public class RomanToDecimal{
	public int getDecimal(String roman){
		if(roman == null || roman.length() == 0){
			return 0;
		}
		int n = roman.length();
		
		int number = getValueForRomanNumeral(roman.charAt(n-1));
		
		for(int i = n-1; i > 0 ; i--){
			int a = getValueForRomanNumeral(roman.charAt(i-1));
			int b = getValueForRomanNumeral(roman.charAt(i));
			if(a < b){
				number = number - a;
			}else{
				number = number + a;
			}
		}
		
		return number;
		
	}
	
	 public int getValueForRomanNumeral(char roman){
        int value = 0 ;
        switch(roman){
            case 'I':
                value = 1;
                break;
             case 'V':
                value = 5;
                break;
             case 'X':
                value = 10;
                break;
             case 'L':
                value = 50;
                break;
             case 'C':
                value = 100;
                break;
             case 'D':
                value = 500;
                break;
             case 'M':
                value = 1000;
                break;                
                
        }
        return value;
    }
	
	
	public static void main(String args[]){
		RomanToDecimal r = new RomanToDecimal();
		System.out.println("Decimal Value = "+r.getDecimal(args[0]));
	}
	
}
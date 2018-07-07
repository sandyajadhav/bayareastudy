public class IntegerToRoman{
	public String getRomanFromInt(int value){
		
		if(value > 3999 && value <=0 ){
			throw new RuntimeException("Invalid number");
		}
		String [] numerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		StringBuilder str = new StringBuilder();
		int i = 0;
		while(value > 0){
			if(value-values[i] >=0){
				value = value - values[i];
				str.append(numerals[i]);
			}else{
				i++;
			}
		}
		
		return str.toString();
	}
	
	public static void main(String args[]){
		int number = Integer.valueOf(args[0]);
		IntegerToRoman itr = new IntegerToRoman();
		
		System.out.println(" Roman Value = "+itr.getRomanFromInt(number));
	}
}
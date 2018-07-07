public class BinaryToDecimal{
	public static void main(String args[]){
		
		String number = args[0];
		
		int decimal = 0;
		int base = 1;
		
		for(int i = number.length()-1; i >=0 ; i-- ){
			char bit = number.charAt(i);
			if(bit == '1'){
				decimal = decimal + base;
			}
			base = base*2;
		}
		
		System.out.println("Decimal value "+decimal);
	}
}
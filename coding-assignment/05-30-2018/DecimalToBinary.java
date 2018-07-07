public class DecimalToBinary{
	public static void main(String args[]){
		
		int decimal = Integer.valueOf(args[0]);
		
		
		String binary = "";

		if(decimal == 0){
			binary = "0";
		}
        while(decimal >0){
        	if(decimal % 2 == 1){
        		binary ="1"+binary;
        	}else{
        		binary = "0"+binary;
        	}
        	decimal = decimal/2;
        }
		System.out.println("Binary value "+binary);
	}
}
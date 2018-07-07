public class PrimeNumber{
	
	public static void main(String args[]){
		
		int []primes = new int[100];
		int limit = 50;
		
		primes[0] = 2;
		int primeCount = 1;
		
		for(int i = 3; i< limit ; i++){
			boolean isPrimeNumber = true;
			if(i%2 == 0){
			  continue;
			}
			
			for(int j= 0; j< primeCount; j++){
				if(i%primes[j]== 0){
					isPrimeNumber = false;
				}
			}
			
			if(isPrimeNumber){
				primes[primeCount++] = i;
			}
		
		}
		
		for(int i =0; i < primes.length; i++){
			if(primes[i] != 0){
				System.out.println(primes[i]);
			}
		}
		
	}
}
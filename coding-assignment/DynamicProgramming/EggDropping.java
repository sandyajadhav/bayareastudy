import java.util.*;


//https://www.youtube.com/watch?v=3hcaVyX00_4
public class EggDropping{
	
	public static int calculate(int eggs, int floors){
	
		int eggFloor[][]= new int[eggs+1][floors+1];
		
		//ond trial for 1st floor and 0th trial for 0th floor
		for(int i =0 ; i<= eggs; i++ ){
			eggFloor[i][1]= 1;
			eggFloor[i][0]= 0;
		}
	
	    //we always need j trials for one eggs and  j floors
	    for(int j=0 ; j<=floors; j++){
			eggFloor[1][j]= j;
	    }
	    
	    for(int i=2; i <=eggs; i++ ){
	    	for(int j= 2; j<= floors; j++){
	    		int min= Integer.MAX_VALUE;
	    		for(int k=1;k<j; k++){
	    			int value = 1+Math.max(eggFloor[i-1][k-1],eggFloor[i][j-k]);
	    		    if(min > value){
	    		    	min = value;
	    		    }
	    		}
	    		eggFloor[i][j] = min;
	    	}
	    }
	    return eggFloor[eggs][floors];
	
	}
	
	
	public static int calculateRecursive(int eggs, int floors){
		if(eggs == 1){
			return floors;
		}
		if(floors == 0){
			return 0;
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=1; i <= floors; i++){
			int val = 1 + Math.max(calculateRecursive(eggs-1,i-1),calculateRecursive(eggs,floors-i));
			if(min >val){
				min = val;
			}
			
		}
		return min;
	}
	
	public static void main(String args[]){
	
		int eggs = Integer.valueOf(args[0]);

	    int floors =  Integer.valueOf(args[1]);
		
		System.out.println(calculateRecursive(eggs,floors));
		System.out.println(calculate(eggs,floors));

	}
}
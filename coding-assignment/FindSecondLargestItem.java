public class FindSecondLargestItem{

public static void main(String args[])throws Exception{
int array[] = {2,1,54,23,5,6};
System.out.println(getSecondLargestItem(array));
}

public static int getSecondLargestItem(int array[])throws Exception{

  if(array.length < 2){
  	throw new Exception("Invalid input");
  }
	int first = Integer.MIN_VALUE;
  int second = Integer.MIN_VALUE;
  
  for(int i =0 ; i < array.length; i++){
  	if(array[i] > first){
    	second = first;
      first = array[i];
    }else if(second < array[i] && first != array[i]){
     second = array[i];
    }
  }
  
  if(second == Integer.MIN_VALUE){
    	throw new Exception("There is no second larget number");
  }
  return second;

}

}
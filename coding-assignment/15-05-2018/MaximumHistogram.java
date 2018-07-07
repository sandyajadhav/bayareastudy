import java.util.*;

public class MaximumHistogram{
	
	public int maxHistogram(int array[]){
		Stack<Integer> stack = new Stack();
		
		int i=0;
		int maxArea = 0;
		
		while(i< array.length){
			if(stack.isEmpty() || array[i]>= array[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				
				int top = stack.pop();
				int area =0;
				if(stack.isEmpty()){
					area = array[top]*i;
				}else{
					area = array[top]*(i- stack.peek()-1);
				}
				
				if(maxArea < area){
					maxArea =area;
				}
			}
			
		}
		
		while(!stack.isEmpty()){
			int area = 0;
			
			int top =stack.pop();
			if(stack.isEmpty()){
				area = array[top]*i;
			}else{
				area = array[top]*(i- stack.peek()-1);
			}
				
			if(maxArea < area){
				maxArea =area;
			}			
		}
		
		return maxArea;
		
	}
	
	public static void main(String args[]){
	
		int array[] = {1,2,4,3};
		MaximumHistogram m= new MaximumHistogram();
		System.out.println("Histogram Area"+m.maxHistogram(array));
		
	}
}
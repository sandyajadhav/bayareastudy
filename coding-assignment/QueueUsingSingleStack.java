
import java.util.*;
public class QueueUsingSingleStack{
	Stack<Integer> stack = new Stack<>();
	
	public void add(int item){
		stack.push(item);
	}
	
	public int poll(){
	 return recursive();
	}
	
	public int recursive(){
		if(stack.size() == 1){
		 return stack.pop();
		}
		int item = stack.pop();
		int result = recursive();
		stack.push(item);
		return result;
	}
	
	public static void main(String args[]){
		
		QueueUsingSingleStack queue = new QueueUsingSingleStack();
		
		queue.add(1);
		queue.add(2);
		System.out.println(queue.poll());	
		queue.add(10);
		System.out.println(queue.poll());
		System.out.println(queue.poll());	
	}
}
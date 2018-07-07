import java.util.*;
public class QueueUsingStack{
	Stack<Integer> stack1 = new Stack();
	Stack<Integer>  stack2 = new Stack();
	
	public int poll() throws Exception{
	
		if(stack1.empty() && stack2.empty()){
			throw new Exception("Queue is empty");
		}
	   if(stack2.empty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
		}
		int item = stack2.pop();
		return item;
	}
	
	public void add(int item){
		stack1.push(item);
	}
	
	
	public static void main(String args[]) throws Exception{
	
		QueueUsingStack queue = new QueueUsingStack();
		
		queue.add(1);
		queue.add(2);
		System.out.println(queue.poll());	
		queue.add(10);
		System.out.println(queue.poll());
		System.out.println(queue.poll());	
	}
	
	
}
import java.util.*;

public class StackUsingQueue{
	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	
	public void push(int item){
		queue2.add(item);
		
		while(!queue1.isEmpty()){
			queue2.add(queue1.poll());	
		}
	
	//swap list
	LinkedList<Integer> temp = 	queue1;
	queue1 = queue2;
	queue2 = temp;
	}

	public int pop(){
		return queue1.poll();
	}

	public static void main(String args[]){
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		System.out.println(stack.pop());	
		System.out.println(stack.pop());
		System.out.println(stack.pop());		
		
	
	}
}
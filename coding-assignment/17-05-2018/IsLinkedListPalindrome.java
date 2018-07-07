public class IsLinkedListPalindrome{

	Node head;
	Node secondHalf;
	
	public void addItem(Node node){
		if(head == null){
			head = node;
		}else{
			node.next = head;
			head = node;
		}
	}
	
	public boolean isLinkedListPalindrome(){
		
		Node slow_ptr= head;
		Node fast_ptr = head;
		Node prev_of_slow_ptr = head;
		
		while(fast_ptr != null && fast_ptr.next != null ){
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		
		Node mid_node = null;
		if(fast_ptr != null){
			mid_node = slow_ptr;
			prev_of_slow_ptr = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		
		secondHalf = slow_ptr;
		reverseSecondHalf();
		prev_of_slow_ptr.next = null; //terminate first list
		
		boolean result = compareLists(head,secondHalf);
		System.out.println("\nMid of linked list "+slow_ptr.data);
		
		reverseSecondHalf();

		if(mid_node != null){
			prev_of_slow_ptr.next = mid_node;
			secondHalf = mid_node.next;
		}else{
			prev_of_slow_ptr.next = secondHalf;
		}
		return result;
	}
	
	public boolean compareLists(Node firstList, Node secondList){
	    Node tempNode1= firstList;
	    Node tempNode2= secondList;
		while(tempNode1.next != null && tempNode2.next != null){
			if(tempNode1.data != tempNode2.data ){
				return false;
			}else{
			tempNode1 = tempNode1.next;
			tempNode2 = tempNode2.next;
			}
		}
	    if(tempNode1==null && tempNode1==null){
			return true;
		}else{
		return false;
		}
	}
	
	public void reverseLinkedList(){
		Node prev= null ;
		Node currentNode = head;
		Node next;
		while(currentNode != null){
			next = currentNode.next;
		    currentNode.next = prev;
		    prev =currentNode;
		    currentNode = next;
		}
		
		head = prev;
	}
	// 1 -> 2->3->4
	// prev =null, next =2, 
	public void reverseSecondHalf(){
		Node prev= null ;
		Node currentNode = head;
		Node next;
		while(currentNode != null){
			next = currentNode.next;
		    currentNode.next = prev;
		    prev =currentNode;
		    currentNode = next;
		}
		
		secondHalf = prev;
	}
	public void displayLinkedList(){
		Node currentNode = head;
		
		while(currentNode != null){
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
			System.out.print("\t");
		}
	}
	
	public static void main(String args[]){
	
			IsLinkedListPalindrome linkedList = new IsLinkedListPalindrome();
			linkedList.addItem(new Node('a'));
			linkedList.addItem(new Node('b'));
			linkedList.addItem(new Node('c'));
			linkedList.addItem(new Node('c'));
			linkedList.addItem(new Node('b'));
			linkedList.addItem(new Node('a'));
			
			linkedList.displayLinkedList();
			linkedList.reverseLinkedList();
			System.out.println();

			linkedList.displayLinkedList();
			System.out.println(linkedList.isLinkedListPalindrome());
			

	}


}

class Node{
	char data;
	Node next;
	
	public Node(char data){
		this.data = data;
	}
}
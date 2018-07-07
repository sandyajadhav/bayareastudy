public class SecondLargestNodeBST{
	
	int count =0;
	
	public void findLargestNode(Node root){
		if(root == null || count >= 2){
			return;
		}
		findLargestNode(root.right);
		
		System.out.println(root.data);
		count++;
		if(count == 2){
			System.out.println("second largest node is "+root.data);
			return ;
		}
		
		findLargestNode(root.left);
		
	}
	
	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(7);
		root.left.left = new Node(6);
		root.left.right = new Node(8);
		
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(25);
		root.right.right.left = new Node(24);
		
		SecondLargestNodeBST s = new SecondLargestNodeBST();
		
		s.findLargestNode(root);

		
	}
}

class Node {
	Node left,right;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}
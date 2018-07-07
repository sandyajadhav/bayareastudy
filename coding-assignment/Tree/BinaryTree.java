public class BinaryTree{

 	public boolean isBst(Node root, int min, int max){
 		
 		if(root == null){
 			return true;
 		}
 		if(root.data <= min || root.data > max){
 			return false;
 		}
 		return isBst(root.left,min,root.data) && isBst(root.right,root.data,max) ;
 	
 	}


	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(7);
		root.left.left = new Node(6);
		root.left.right = new Node(8);
		
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(25);
		root.right.right.left = new Node(25);

		
		BinaryTree binaryTree = new BinaryTree();
		System.out.println(binaryTree.isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}

class Node {
	Node left,right;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}
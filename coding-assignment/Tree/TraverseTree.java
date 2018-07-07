import java.util.*;
public class TraverseTree{

 	public void printInPreOrder(Node root){
 		if(root == null){
 			return ;
 		}
 		System.out.print(root.data+"\t");
 		printInPreOrder(root.left);
 		printInPreOrder(root.right);
 	}
 	
 	public void printInOrder(Node root){
 		if(root == null){
 			return ;
 		}
 		printInOrder(root.left);
 		System.out.print(root.data+"\t");
 		printInOrder(root.right);
 	}
 	
 	public void printPostOrder(Node root){
 		if(root == null){
 			return ;
 		}
 		printPostOrder(root.left);
 		printPostOrder(root.right);
 		System.out.print(root.data+"\t");

 	}
 	
 	//breadth first traversal   
 	public void leverOrder(Node root){
 		Queue<Node> queue = new LinkedList();
 		if(root != null){
 			queue.add(root);
 		}

		while(!queue.isEmpty()){
		    Node node = queue.poll();
			System.out.print(node.data+"\t");
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		} 		
 	
 	}
 	
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		
		//preOrder , inOrder and postOrder ad Depth First Search traversal  
		TraverseTree traverseTree = new TraverseTree();
		//1 2 4 5 3 6
		traverseTree.printInPreOrder(root);
		System.out.println();
		
		//4 2 5 1 6 3 
		traverseTree.printInOrder(root);
		System.out.println();
		
		//4 5 2 6 3 1
		traverseTree.printPostOrder(root);
		System.out.println();

		//1 2 3 4 5 6
		traverseTree.leverOrder(root);
		System.out.println();
		
	}
}
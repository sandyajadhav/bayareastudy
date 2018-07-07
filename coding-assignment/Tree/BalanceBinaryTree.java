import java.util.*;
public class BalanceBinaryTree{
	
	public void storeNodes(Node root,List<Node> nodes){
		if(root == null){
			return ;
		}
		storeNodes(root.left,nodes);
		nodes.add(root);
		storeNodes(root.right,nodes);
		
	}
	
	public Node balanceTree(Node root,int left, int right,List<Node> nodes){
		if(left > right){
			return null;
		}
		int mid = (left + right)/2;
		Node midNode = nodes.get(mid);
		
		midNode.left =  balanceTree(midNode,left,mid-1,nodes);
		midNode.right = balanceTree(midNode,mid+1,right,nodes);
		return midNode;
	}
	
	public Node balanceTree(Node root){
		List<Node> nodes = new ArrayList();
		storeNodes(root,nodes);
		
		return balanceTree(root,0,nodes.size()-1,nodes);
	}
	
	public void displayTreePreOrder(Node root){
		if(root == null){
		return ;
		}
		System.out.println(root.data);
		displayTreePreOrder(root.left);
		displayTreePreOrder(root.right);
	}
	
	public void levelOrder(Node root){
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		
		while(true){
			int nodeCount = queue.size();
			if(nodeCount == 0){
				break;
			}
			
			while(nodeCount >0){
				Node node = queue.poll();
				System.out.print(node.data+" ");
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
				nodeCount--;
			}
			System.out.println();
		}
		
		
	}
	
	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(7);
		root.left.left = new Node(6);
		root.left.left.left = new Node(15);

		root.left.left.left.left = new Node(25);

		root.left.right = new Node(8);
	
		root.right = new Node(20);
		root.right.left = new Node(15);

		
		BalanceBinaryTree binaryTree = new BalanceBinaryTree();
		binaryTree.levelOrder(root);
		root = binaryTree.balanceTree(root);
		System.out.println("After balance");
		binaryTree.levelOrder(root);
	}
}

class Node{
	Node left,right;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}
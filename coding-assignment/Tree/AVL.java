public class AVL{
    TreeNode root;

	public TreeNode insert(TreeNode node,int data){
		if(node == null){
			return new TreeNode(data);
		}
		
		if(data < node.data){
			node.left = insert(node.left,data);
		}else if(data > node.data){
			node.right = insert(node.right,data);
		}else{
			return node; //Assuming duplicates are not allowed
		}
		
		node.height = 1 + max(height(node.left), height(node.right));
		
		int balance = getBalance(node);
		System.out.println("balance for"+node.data+" = "+balance);
		
		//left left chase
		if(balance > 1 && data < node.left.data){
			return rotateRight(node);
		}
		
		//Right right chase
		if(balance < -1 && data > node.right.data){
			return rotateLeft(node);
		}
		 
		if(balance >1 && data > node.left.data){
		    node.left = rotateLeft(node.left);
		    return rotateRight(node);
		} 
		
		if(balance < -1 && data < node.right.data){
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
	    return node;
		
	}

	public int height(TreeNode node){
		if(node == null){
			return 0;
		}
		return node.height;
	}

	public TreeNode rotateLeft(TreeNode z){
		System.out.println("Rotating left "+z.data);
		TreeNode y = z.right;
		TreeNode temp = y.left;
		
		z.right = temp;
		y.left = z;
		
		z.height = max(height(z.left), height(z.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
 	public TreeNode rotateRight(TreeNode z){
 		System.out.println("Rotating right "+ z.data);

 		TreeNode x = z.left;
 		TreeNode temp = x.right;
 		
 		x.right = z;
 		z.left = temp;
 		
 		x.height = 1 + max(height(x.left),height(x.right));
 		z.height = 1 + max(height(z.left), height(z.right));
 		return x;
 	}

	public int max(int a,int b){
		return a>b? a : b;
	}
	public int getBalance(TreeNode node){
		return (height(node.left) - height(node.right));
	}
	
	//root-left-right
	public void preOrder(TreeNode node){
		if(node == null){
			return ;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
	public static void main(String args[]){
       AVL tree = new AVL();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 21);

		tree.preOrder(tree.root);

	}

}

class Height{
	int height;
	
}
class TreeNode{
	int data;
	int height;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
		height = 1;
	}
	
	
}
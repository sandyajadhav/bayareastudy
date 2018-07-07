
import java.util.*;
public class LevelOrder {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList();

        q.add(root);
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }

            while (nodeCount > 0) {
                Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                nodeCount--;

            }

            System.out.println();


        }
    }


    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printLevelOrder(root);


    }
}
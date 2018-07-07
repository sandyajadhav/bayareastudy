import java.util.*;

interface LRU{
	public int get(int key);
	public void set(int key,int data);
	public void displayNode();
}
public class LRUCache implements LRU{
	private Node head;
	private Node end;
	
	//Using map to fetch data in O(1) complexity by compromising space complexity of O(N)
	private Map<Integer,Node> map = new HashMap();
	private int capacity;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	private void setHead(Node node){
		node.prev = null;
		if(head != null){
			head.prev = node;
		}
		node.next = head;
		head = node;
		
		if(end == null){
			end = head;
		}
	}
	
	private void remove(Node node){
		if(node.prev != null ){
			node.prev.next = node.next;
		}else{
			head = node.next;
		}
		if(node.next != null ){
			node.next.prev = node.prev;
		}else{
			end = node.prev;
		}
		
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			int value = node.data;
			remove(node);
			setHead(node);
			return value;
		}
		return -1;
	}
	
	public void set(int key,int value){
		if(!map.containsKey(key)){
			Node createdNode = new Node(key,value);
			if(map.size() >= capacity){
				map.remove(end.key);
				remove(end);
				setHead(createdNode);
			}else{
				setHead(createdNode);
			}
			map.put(key,createdNode);
		}else{
			Node oldNode = map.get(key);
			oldNode.data = value;
			remove(oldNode);
			setHead(oldNode);
		}
	}
	
	public void displayNode(){
	    Node currentNode = head;
		while(currentNode != null){
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	
	public static void main(String args[]){
		LRU lru = new LRUCache(4);
		lru.set(1,1);
		lru.set(2,2);
		lru.set(3,3);
		lru.set(4,4);
		lru.set(5,5);
		
		lru.displayNode();
		
		System.out.println("getting new value"+lru.get(3));
		System.out.println("New order");

		lru.displayNode();

	}
}

class Node{
	int data;
	int key;
	Node next;
	Node prev;
	
	public Node(int key, int data){
		this.key = key;
		this.data = data;
	}
}
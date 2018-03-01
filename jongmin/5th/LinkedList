package algorithm1st;

import org.w3c.dom.Node;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		private Object data;
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
	}
	
	public void addFirst(Object data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(Object data) {
		Node node = new Node(data);
		if(size==0) {
			addFirst(data);
		}
		else {
			tail.next = node;
			tail = node;
			size++;
		}
	}
	public void add(int index, Object data) {
		if(index ==0) {
			addFirst(data);
		} else {
			Node temp1 = node(index-1);
			Node temp2 = temp1.next;
			Node node = new Node(data);
			temp1.next = node;
			node.next = temp2;
			size++;
			if(node.next==null) {
				tail = node;
			}
		}
	}
	
	public Object removeFirst() {
		Node remove = head;
		head = remove.next;
		Object data = remove.data;
		remove = null;
		size--;
		return data;
	}
	
	public Object remove(int index) {
		if(index==0) return removeFirst();
		Node temp = node(index - 1);
		Node remove = temp.next;
		temp.next = temp.next.next;
		Object returnData = remove.data;
		if(remove == tail){
			tail = temp;
		}
		remove = null;
		size--;
		return returnData;
	}
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Object get(int index) {
		Node temp = node(index);
		return temp.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object data) {
		for(int i=0;i<size;i++) {
			if(data.equals(get(i))) {
				return true;
			}
		}
		return false;
	}
	
	Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	
}

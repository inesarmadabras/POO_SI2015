package First_Work;

import java.util.EmptyStackException;

public class SlinkedList<E> implements Stack<E> {

	public class Node<E>{
		public  E data;
		public Node<E> next;
		public Node(E item){data = item;}
	}

	
	private Node<E> head;

	public SlinkedList(){
		head = null;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public E push(E item){
		Node<E> x = new Node<E>(item);

		if(head == null) head =x;

		else{
			x.next = head;
			head = x;
		}
		return head.data;
	}

	public E peek() {
		if (head == null) throw new EmptyStackException();
		return head.data;
	}
	
	
}

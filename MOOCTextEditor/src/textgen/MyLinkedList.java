package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		this.size = 0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) 
		{
			throw new NullPointerException("Class is null");
		}

		if (head.next.equals(tail)) 
		{
			
			LLNode<E> Node = new LLNode<E>(element);
			/*Node.next= head.next;
			Node.prev= Node.next.prev;
			Node.next.prev = Node;
			head.next= Node;
			this.size++;*/
			
			Node.next=tail;
			Node.prev=tail.prev;
			tail.prev.next=Node;
			tail.prev=Node;
			this.size++;
		}
		else 
		{
			
			LLNode<E> Node = new LLNode<E>(element);
			//Adds each node at the back, attaches to the back sentinel node
			/*Node.next= head.next;
			Node.prev= Node.next.prev;
			Node.next.prev = Node;
			head.next= Node;
			this.size++;*/
			
			//adds each node in the front,attaches to the head sentinel node
			Node.next=tail;
			Node.prev=tail.prev;
			tail.prev.next=Node;
			tail.prev=Node;
			this.size++;
			
		}

		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// throw error if index input is out of bounds
			if(index < 0 || index > this.size-1 || size == 0) 
			{
				throw new IndexOutOfBoundsException("Index value is out of bounds of the list");	
			}
			//iterate through list starting at the head of the list return data from node at index value
			LLNode <E> tmp = new LLNode <E> (null);
			tmp = head; //set temp node to beginning of list
			for (int i = 0; i <= index; i++) 
			{
				tmp = tmp.next; //set to next node for iteration
				//System.out.println(tmp.data);
			}
			return tmp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
		if (element == null) 
		{
			throw new NullPointerException("Tou cannot insert a null value");
		}
		
		if (index > size || index < 0 ) 
		{
			throw new IndexOutOfBoundsException("Index value is out of bounds of the list");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		
		LLNode <E> tmp = new LLNode <E> (null);
		tmp = head; //set temp node to beginning of list
		for (int i = 0; i <= index; i++) 
		{
			tmp = tmp.next; //set to next node for iteration
			//System.out.println(tmp.data);
		}
		LLNode<E> oldNode = tmp;
		
		newNode.next = oldNode;
		newNode.prev = oldNode.prev;
		oldNode.prev.next = newNode;
		oldNode.prev = newNode;
		this.size++;

	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index > size || index < 0 ) 
		{
			throw new IndexOutOfBoundsException("Index value is out of bounds of the list");
		}
		
		LLNode <E> tmp = new LLNode <E> (null);
		tmp = head; //set temp node to beginning of list
		for (int i = 0; i <= index; i++) 
		{
			tmp = tmp.next; //set to next node for iteration
			//System.out.println(tmp.data);
		}
		LLNode<E> oldNode = tmp;
		oldNode.next.prev = oldNode.prev;
		oldNode.prev.next = oldNode.next;
		oldNode.next = oldNode;
		oldNode.prev = oldNode;
		this.size--;
		
		return oldNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) 
		{
			throw new NullPointerException("Tou cannot insert a null value");
		}
		
		if (index > size || index < 0 ) 
		{
			throw new IndexOutOfBoundsException("Index value is out of bounds of the list");
		}
		LLNode <E> tmp = new LLNode <E> (null);
		tmp = head; //set temp node to beginning of list
		for (int i = 0; i <= index; i++) 
		{
			tmp = tmp.next; //set to next node for iteration
			//System.out.println(tmp.data);
		}
		LLNode<E> oldNode = tmp;
		E old = oldNode.data;
		LLNode<E> newNode = new LLNode<E>(element);
		oldNode.data = newNode.data;

		return old;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

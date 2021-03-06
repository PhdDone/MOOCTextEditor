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
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		int size = 0;
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		++this.size;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0) throw new IndexOutOfBoundsException();
		LLNode<E> cur = head.next;
		for (int i = 0; i < index; ++i) {
			cur = cur.next;
		}
		return cur.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index > size) throw new IndexOutOfBoundsException();
		LLNode<E> cur = head;
		for (int i = 0; i < index; ++i) {
			cur = cur.next;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = cur.next;
		newNode.next.prev = newNode;
		newNode.prev = cur;
		cur.next = newNode;
		++size;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> cur = head;
		for (int i = 0; i < index; ++i) {
			cur = cur.next;
		}
		E element = cur.next.data;
		cur.next = cur.next.next;
		cur.next.prev = cur;
		--size;
		return element;
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
		// TODO: Implement this method
		if (index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> cur = head;
		for (int i = 0; i < index; ++i) {
			cur = cur.next;
		}
		E oldElement = cur.next.data;
		cur.next.data = element;
		
		return oldElement;
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

package simpleLinkedList;
class Node<T>
{
	private T object;
	private Node<T> next;
	
	public Node(T object)
	{
		this.object = object;
		next = null;
	}
	
	public Node(T object, Node<T> next)
	{
		this.object = object;
		this.next = next;
	}
	
	public T getobject()
	{
		return object;
	}
	
	public void setobject(T newobject)
	{
		object = newobject;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setNext(Node<T> newNext)
	{
		next = newNext;
	}
	
	@Override
	public String toString()
	{
		return object.toString();
	}
}




public class SimpleLinkedList<T extends Comparable<T>> {
	private Node<T> start;
	private int size;
	
	/**
	 * Constructor
	 */
	public SimpleLinkedList()
	{
		start = new Node<>(null);
	}
	
	/**
	 * Adds a new object to the start of the list
	 * @param object
	 */
	public void addAtStart(T object)
	{
		start.setNext(new Node<>(object, start.getNext()));
		size++;
	}
	
	/**
	 * Adds a new object to the last position of the List
	 * @param object
	 */
	public void add(T object)
	{
		getLastNode().setNext(new Node<T>(object));
		size++;
	}
	
	/**
	 * Adds an object to the specified position
	 * @param position
	 * @param object
	 * @throws CustomException
	 */
	public void addAt(int position, T object) throws CustomException
	{
		Node<T> temp = getNode(position - 1);
		
		temp.setNext(new Node<>(object, temp.getNext()));
		
		size++;
	}
	
	/**
	 * Eliminate a object in the given position
	 * @param position
	 * @throws CustomException
	 */
	public void eliminate(int position) throws CustomException
	{
		if (isEmpty())
		{
			throw new CustomException("The list is empty");
		}
		else if (position >= size)
		{
			throw new CustomException("The position you are trying to eliminate does not exist");
		}
		
		// Search for the node in the specified position
		int i = 0;
		Node<T> beforeThanToEliminate = start;
		Node<T> toEliminate = start.getNext();
		for ( ; i < position && toEliminate != null; i++, beforeThanToEliminate = toEliminate, toEliminate = toEliminate.getNext());
		
		beforeThanToEliminate.setNext(toEliminate.getNext());
		
		size--;
	}
	
	/**
	 * Eliminates the given object off the list
	 * @param object
	 * @throws CustomException
	 */
	public void eliminate(T object) throws CustomException
	{
		if (isEmpty())
		{
			throw new CustomException("The List is empty");
		}
		Node<T> previousToEliminate = start;
		Node<T> toEliminate = start.getNext();
		
		while (toEliminate != null && toEliminate.getobject().compareTo(object) != 0)
		{
			previousToEliminate = toEliminate;
			toEliminate = toEliminate.getNext();
		}
		
		if (toEliminate == null)
		{
			throw new CustomException("The item you want to eliminate does not exist");
		}
		
		previousToEliminate.setNext(toEliminate.getNext());
		
		size--;
	}
	
	/**
	 * Returns true if the list is empty, else, returns false
	 * @return
	 */
	public boolean isEmpty()
	{
		return (size == 0) ? true : false;
	}
	
	/** 
	 * returns the length of the Simple Linked List
	 * @return
	 */
	public int length()
	{
		return size;
		
		/*int result = 0;
		Node<T> temp = start;
		while (temp != null)
		{
			temp = temp.getNext();
			result ++;
		}
		
		return result;*/
	}
	
	/**
	 * Returns the last object in the Simple Linked List
	 * @return object
	 */
	public T getLast()
	{
		return getLastNode().getobject();
	}
	
	/**
	 * Returns the index of the specified object
	 * @param object
	 * @return position
	 */
	public int getIndexOf(T object)
	{
		Node<T> temp = start.getNext();
		int number = 0;
		
		while(temp != null && temp.getobject().compareTo(object) != 0)
		{
			temp = temp.getNext();
			number++;
		}
		
		return (temp == null) ? -1 : number;
		
	}
	
	/**
	 * Returns the object at the given postion
	 * @param position
	 * @return object
	 * @throws CustomException
	 */
	public T getobjectAt(int position) throws CustomException
	{
		return getNode(position).getobject();
	}
	
	/**
	 * Prints the list to the console
	 */
	public void printList()
	{
		for (Node<T> temp = start.getNext(); temp != null; temp = temp.getNext())
		{
			System.out.print(temp.getobject().toString() + "        ");
		}
		System.out.println();
	}
	
	/**
	 * Return the last node in the list
	 * @return node
	 */
	private Node<T> getLastNode()
	{
		//for (Node<T> temp = start; temp != null; temp = temp.getNext());
		
		Node<T> temp = start;
		
		while (temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		return temp;
	}
	
	/**
	 * Returns the node at the given position
	 * @param position
	 * @return Node
	 * @throws CustomException
	 */
	private Node<T> getNode(int position) throws CustomException
	{
		if (position >= size)
		{
			throw new CustomException("The position you are looking for does not exist");
		}
		
		int i = 0;
		Node<T> temp;
		for (temp = start.getNext(); i < position && temp != null; i++, temp = temp.getNext());
		
		return temp;
	}

}







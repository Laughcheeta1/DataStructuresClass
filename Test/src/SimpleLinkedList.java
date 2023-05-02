class Node<T>
{
	private T info;
	private Node<T> next;
	
	public Node(T info)
	{
		this.info = info;
		next = null;
	}
	
	public Node(T info, Node<T> next)
	{
		this.info = info;
		this.next = next;
	}
	
	public T getInfo()
	{
		return info;
	}
	
	public void setInfo(T newInfo)
	{
		info = newInfo;
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
		return info.toString();
	}
}

public class SimpleLinkedList<T extends Comparable<T>> {
	private Node<T> start;
	
	public SimpleLinkedList()
	{
		start = new Node<>(null);
	}
	
	public void addAtStart(T info)
	{
		start.setNext(new Node<>(info, start.getNext()));
	}
	
	public void add(T info)
	{
		getLastNode().setNext(new Node<T>(info));
	}
	
	public void addAt(int position, T info)
	{
		Node<T> temp = getNode(position - 1);
		if (temp == null)
		{
			Excep No existe el pos
		}
		temp.setNext(new Node<>(info, temp.getNext()));
	}
	
	public void eliminate(int position)
	
	public void eliminate(T info)
	{
		if (isEmpty())
		{
			
		}
		Node<T> toEliminate = start.getNext();
		/*Hacer que esto recorra elimine de la lista sin tener que usar estos metodos, ya que es muy ineficiente,
		peudes hacer algo que guarde el nodo que quieres, y el anterior, para asi eliinar, y si no se elimino nada, que saqe exception
		
		int indexOfNodeToEliminate = getIndexOf(info);
		
		if (indexOfNodeToEliminate == -1)
		{
			exception
		}
		
		Node<T> nodeToEliminate = getNode(indexOfNodeToEliminate);
		Node<T> nodePrevious = getNode(indexOfNodeToEliminate - 1);
		
		nodePrevious.setNext(nodeToEliminate.getNext());*/
	}
	
	public boolean isEmpty()
	{
		return start == null;
	}
	
	public int length()
	{
		int result = 0;
		Node<T> temp = start;
		while (temp != null)
		{
			temp = temp.getNext();
			result ++;
		}
		
		return result;
	}
	
	public T getLast()
	{
		return getLastNode().getInfo();
	}
	
	public int getIndexOf(T info)
	{
		Node<T> temp = start.getNext();
		int number = 0;
		
		while(temp != null && temp.getInfo().compareTo(info) != 0)
		{
			temp = temp.getNext();
			number++;
		}
		
		return (temp == null) ? -1 : number;
		
	}
	
	public T getInfoAt(int position)
	{
		return getNode(position).getInfo();
	}
	
	public void printList()
	{
		for (Node<T> temp = start.getNext(); temp != null; temp = temp.getNext())
		{
			System.out.print(temp.getInfo().toString() + "        ");
		}
		System.out.println();
	}
	
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
	
	private Node<T> getNode(int position)
	{
		int i = 0;
		Node<T> temp;
		for (temp = start.getNext(); i < position && temp != null; i++, temp = temp.getNext());
		
		return temp;
	}
	
	/*private Node<T> getNodeByInfo(T info)
	{
		Node<T> temp = start.getNext();
		
		while(temp != null && temp.getInfo().compareTo(info) != 0)
		{
			temp = temp.getNext();
		}
		
		return temp;
		
	}*/
}







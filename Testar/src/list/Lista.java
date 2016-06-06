package list;

public class Lista {
	
	private int key;
	private Lista next;
	private Lista head = null;
	private Lista aux = null;
	
	public Lista(int key)
	{
		this.key = key;
		this.next = null;
	}
	
	public void insert(int key)
	{
		Lista novo = new Lista(key);
		if(head == null) head = aux = novo;
		else
		{
			aux.next = novo;
			aux = novo;
		}
	}
	
	public void remove(int key)
	{
		Lista temp;
		for(temp = head; temp != null; temp = temp.next)
		{
			
		}
	}

}

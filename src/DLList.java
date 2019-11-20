/**
 * This class implements the DLListADT and defines a doubly linked list. It has various methods that will be used in ShortestPath.
 *  
 * @author Jian Xie
 * 
 * @version  March 2019
 */
public class DLList<T> implements DLListADT<T>{
	private DLNode<T> front;
	private DLNode<T> rear;
	private int count;

	/**
	 * Creates an empty list.
	 */
	public DLList() {
		front = null;
		rear = null;
		count = 0;
	}

	/**
	 * Inserts a data item into the rear of the list.
	 * @param dataItem the data item to be inserted.
	 * @param value the value to be inserted.
	 */
	@Override
	public void insert(T dataItem, int value) {
		DLNode<T> node = new DLNode(dataItem, value);
        if(isEmpty()){
                front = rear = node;
        }
        else {
                rear.setNext(node);
                node.setPrevious(rear);
                rear = node;
        }
        count++;
}

	/**
	 * Returns the value of a specified data item.
	 * @param dataItem the data item in which you want the value for.
	 * @throws InvalidDataItemException
	 * 			An invalid data item that is trying to be accessed.
	 */
	@Override
	public int getDataValue(T dataItem) throws InvalidDataItemException {
		DLNode<T> previous = null;
		DLNode<T> current = front;
		while (current != null) {
			if (current.getDataItem().equals(dataItem)) {
				return current.getValue();
			}
			else {
				current = current.getNext();
				previous = current;
			}
		}
		throw new InvalidDataItemException("An exception was thrown because you tried to get an invalid data item.");
	}
	
	
	/**
	 * Changes the value of a data item.
	 * @param dataItem the data item in which you want to change the value for.
	 * @param newValue the new value you want to be changed to.
	 * @throws InvalidDataItemException
	 * 			An invalid data item that is trying to be accessed.
	 */
	@Override
	public void changeValue(T dataItem, int newValue) throws InvalidDataItemException {
		DLNode<T> next = null;
		DLNode<T> current = front;
		boolean found = false;
		
		while (current != null) {
			if (current.getDataItem().equals(dataItem)) {
				current.setValue(newValue);
				found = true;
				break;
			}
			else {
				current = current.getNext();
			}
		}
		if (found == false) {
			throw new InvalidDataItemException("An exception was thrown because you tried to change an invalid data item.");
		}
	}
		
	/**
	 * Returns and removes the node with the smallest value.
	 * @return the node with the smallest value.
	 * @throws EmptyListException
	 * 			An error in which the list is empty.
	 */
	@Override
	public T getSmallest() throws EmptyListException {
		DLNode<T> current = front;
		DLNode<T> smallNode = front;
		
		
		if (isEmpty()) {
			throw new EmptyListException("An exception was thrown because the list is empty.");
		}
		// if there is only one item in the list it returns itself.
		if (count == 1) {
			T returnReference = current.getDataItem();
			current = null;
			count--;
			return returnReference;
		}
			
		while (current != null) {
				if (current.getValue() < smallNode.getValue()) {
					smallNode = current;
				}
			else {
				current = current.getNext();
			}
		}
		
		//checks the conditions to remove the node varying on where the node is.
		if (smallNode == front) {
			if (smallNode == rear) {
				front = null;
				rear = null;
			}
			else {
				front = smallNode.getNext();
				front.setPrevious(null);
			}
		}
		else {
			if (smallNode == rear) {
				rear = smallNode.getPrevious();
				rear.setNext(null);
			}
		}
		count--;
		return  smallNode.getDataItem();
	}
	
	/**
	 * Returns true if empty, false otherwise.
	 * @return true if empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	
	/**
	 * Returns the number of data items in the list.
	 * @return the number of data items in the list.
	 */
	@Override
	public int size() {
		return count;
	}
    /**
  	 * Returns a string representation of the list.
  	 * @return The string representation of the list.
  	 */
	@Override
	 public String toString(){
        DLNode<T> cn = front;
        String str = "List: ";
        while(cn != null){
                str += cn.getDataItem() +"," + cn.getValue() + ";";
                cn = cn.getNext();
        }
        return str;
	}
}

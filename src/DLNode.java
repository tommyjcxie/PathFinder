/**
 * This class defines the node in the DLList.
 *  
 * @author Jian Xie
 * 
 * @version March 2019
 */
public class DLNode<T>{
	private T dataItem;
	private DLNode<T> next;
	private DLNode<T> previous;
	private int value;
	
	 /**
	  * Constructor for the node.
	  */
	public DLNode (T data, int value) {
		next = null;
		previous = null;
		this.dataItem = data;
		this.value = value;
	}
	
	/**
	 * Returns the data value of the node.
	 * @return the data value of the node.
	 */
    public int getValue() {
        return this.value;
    }
    
    /**
	 * Returns the data item stored in the node.
	 * @return the data item stored in the node.
	 */
    
    public T getDataItem() {
    	return this.dataItem;
    }
    
    /**
  	 * Returns a reference to the next node.
  	 * @return a reference to the next node.
  	 */
    public DLNode<T> getNext(){
        return this.next;
    }
    
    /**
  	 * Returns a reference to the prev node.
  	 * @return a reference to the prev node.
  	 */
    public DLNode<T> getPrevious(){
        return previous;
    }
    
    /**
  	 * Sets the value of the next node.
  	 */
    public void setNext (DLNode<T> node) {
        this.next = node;
    }
    
    /**
  	 * Sets the data of the current node.
  	 */
    public void setData (T data) {
       this.dataItem = data;
    }
    
    /**
  	 * Sets the data of the previous node.
  	 */
    public void setPrevious(DLNode<T> node) {
       this.previous = node;
    }
    
    /**
  	 * Sets the value of the current node.
  	 */
    public void setValue(int newValue) {
    	this.value = newValue;
    }

    
}

 
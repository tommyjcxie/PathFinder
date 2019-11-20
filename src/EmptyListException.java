/**
 * Represents the exception thrown when the list is empty.
 *  
 * @author Jian Xie
 * 
 * @version February 2019
 */

public class EmptyListException extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message.
   * @param message String representing the error encountered
   */
  public EmptyListException (String message) {
    super (message);
  }
}

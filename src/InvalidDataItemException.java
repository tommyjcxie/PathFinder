/**
 * Represents the exception thrown when trying to access an invalid data item.
 *  
 * @author Jian Xie
 * 
 * @version February 2019
 */

public class InvalidDataItemException extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message.
   * @param message String representing the error encountered
   */
  public InvalidDataItemException (String message) {
    super (message);
  }
}

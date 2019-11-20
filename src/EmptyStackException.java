/**
 * Represents the situation in which the user tries to pop/peek but the stack is empty.
 *  
 * @author Jian Xie
 * 
 * @version February 2019
 */

public class EmptyStackException extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message for when the stack is empty.
   * @param message explains the error that threw the exception
   */
  public EmptyStackException (String message)
  {
    super ("Error, the stack is empty but you tried to " + message);
  }
}

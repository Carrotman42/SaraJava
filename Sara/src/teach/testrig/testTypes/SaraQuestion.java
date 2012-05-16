package teach.testrig.testTypes;

/**
 * A class that represents the basic structure of a question you'll be
 * answering
 * 
 * @author Kevin
 * @version 2012.05.04
 */
public abstract class SaraQuestion {
   /**
    * 
    * @return true if you want to test the solution in this file during the
    * next test run, false if you want to skip it.
    */
   public abstract boolean testSolution();
   
   /**
    * A specially made function that you shouldn't touch. Feel free to look at
    * the implementation, but don't feel bad if it goes over your head right
    * now. You'll understand it when you've learned enough :)
    * 
    * @param args Args passed to the test
    * @return The solution to the test
    */
   public abstract Object test(Object args);
}

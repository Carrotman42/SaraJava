package teach.testrig.testTypes;


public abstract class StringToStringTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract String test(String arg1);
   
   @Override
   public Object test(Object arg) {
      return test((String)arg);
   }
}

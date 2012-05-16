package teach.testrig.testTypes;


public abstract class IntToIntArrTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract int[] test(int arg);
   
   @Override
   public Object test(Object args) {
      return test((int)args);
   }
}

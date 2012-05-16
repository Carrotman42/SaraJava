package teach.testrig.testTypes;


public abstract class NoneToIntArrTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract int[] test();
   
   @Override
   public Object test(Object args) {
      
      return test();
   }
}

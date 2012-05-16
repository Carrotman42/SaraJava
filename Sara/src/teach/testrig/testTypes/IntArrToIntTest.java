package teach.testrig.testTypes;

import teach.testrig.TypeHelper;



public abstract class IntArrToIntTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract int test(int[] arg);
   
   @Override
   public Object test(Object args) {
      
      return test(TypeHelper.convIntegerToint((Integer[])args));
   }
   
}

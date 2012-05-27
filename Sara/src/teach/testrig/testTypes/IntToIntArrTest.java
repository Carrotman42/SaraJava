package teach.testrig.testTypes;

import teach.testrig.TypeHelper;


public abstract class IntToIntArrTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract int[] test(int arg);
   
   @Override
   public Object test(Object args) {
      return TypeHelper.convIntToInteger((test((int)args)));
   }
}

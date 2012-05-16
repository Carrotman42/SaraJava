package teach.testrig.testTypes;


public abstract class Int3ToIntTest extends SaraQuestion {
   
   @Override
   public abstract boolean testSolution();
   
   public abstract int test(int arg1, int arg2, int arg3);
   
   @Override
   public Object test(Object args) {
      Object[] arr = (Object[])args;
      
      return test((int)arr[0], (int)arr[1], (int)arr[2]);
   }
}

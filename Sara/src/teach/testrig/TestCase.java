package teach.testrig;

import java.util.List;

import teach.testrig.testTypes.SaraQuestion;

public class TestCase {
   private static final Test[] DUMMY = new Test[0];
   private final Test[] ts;
   
   public TestCase(Test...tests){
      ts = tests;
   }
   
   public TestCase(List<Test> tests) {
      this(tests.toArray(DUMMY));
   }
   
   public int test(SaraQuestion q, boolean verbose){
      int passed = 0;
      
      for (Test t:ts) {
         if (t.test(q)) {
            passed++;
         }else if (verbose){
            System.out.println("\tTest failed!");
            t.printInfo("\t\t", true);
         }
      }
      
      return passed;
   }
   
   public int testCount() {
      return ts.length;
   }
   
   static class Test {
      private final Object a, r;
      
      //Note: Being threadsafe is annoying.
      private Object last;
      
      boolean test(SaraQuestion q) {
         return TypeHelper.test(r, last = q.test(a));
      }
      
      void printInfo(String indent, boolean printAnswer) {
         System.out.println(indent + "Arguments: " + TypeHelper.toString(a));
         System.out.println(indent +    "Your answer: " + TypeHelper.toString(last));
         if (printAnswer)
            System.out.println(indent + "Expected   : " + TypeHelper.toString(r));
      }
      
      Test(Object args, Object result){
         a=args;
         r=result;
      }
   }
}

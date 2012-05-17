package teach.kevin_reference_solutions;

import teach.testrig.testTypes.StringToStringTest;

public class ToUppercase extends StringToStringTest {
   
   public boolean testSolution() {
      return true;
   }
   
   public String test(String arg1) {
      return arg1.toUpperCase();
   }
   
}

package teach.kevin_reference_solutions;

public class AbsoluteValue extends teach.testrig.testTypes.IntToIntTest {
   public boolean testSolution() {
      return true;
   }

   public int test(int arg) {
      return arg >= 0 ? arg : -arg;
   }
}

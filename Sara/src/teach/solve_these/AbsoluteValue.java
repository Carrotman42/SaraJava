package teach.solve_these;

public class AbsoluteValue extends teach.testrig.testTypes.IntToIntTest {
   public boolean testSolution() {
      return true;
   }

   public int test(int arg) {

      if (arg >= 0){
          return arg;
      } else {
          return -arg;
      }
   }
}

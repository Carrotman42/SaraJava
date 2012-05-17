package teach.kevin_reference_solutions;

import teach.testrig.testTypes.IntArrToIntTest;

public class SumOfIntegerArray extends IntArrToIntTest {

   public boolean testSolution() {
      return true;
   }
   
   public int test(int[] arg) {
       int sum = 0;
              
       for (int elem : arg){
           //Note: This is also literally exactly the same as above
           //  programmers invented this because the for-loop over an array is so often used
           //  that they made this one to be lazier!
           sum += elem;
       }
       
       return sum;
   }
   
}

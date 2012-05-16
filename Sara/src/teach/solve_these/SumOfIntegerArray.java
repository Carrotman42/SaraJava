package teach.solve_these;

import teach.testrig.testTypes.IntArrToIntTest;

public class SumOfIntegerArray extends IntArrToIntTest {

   public boolean testSolution() {
      return true;
   }

   public int test(int[] arg) {
       int pot = 0;
              
       for (int i = 0; i < arg.length; i++){
          pot = arg[i] + pot;
          
       }
       
       return pot;
   }
   
   public int kevins(int[] arg) {
       int pot = 0;
              
       for (int i = 0; i < arg.length; i++){
           //Note: This is literally exactly the same thing as above, but it allows you to be
           //    lazier
           pot += arg[i];
       }
       
       return pot;
   }
   
   public int kevinsenhanced(int[] arg) {
       int pot = 0;
              
       for (int elem : arg){
           //Note: This is also literally exactly the same as above
           //  programmers invented this because the for-loop over an array is so often used
           //  that they made this one to be lazier!
           pot += elem;
       }
       
       return pot;
   }
   
}

package teach.solve_these;

import teach.testrig.testTypes.NoneToIntArrTest;

public class GenerateFibonacci extends NoneToIntArrTest {

   public boolean testSolution() {
       
      return true;
   }

   public int[] test() {
      int lastnum = 1;
      int nextnum = 0;
      int thisnum = 0;
      int[] answer = new int[10];
   
   
   
       for (int i = 0; i < 10; i++){
           thisnum = lastnum + nextnum;
           lastnum = nextnum;
           nextnum = thisnum;
           answer[i] = thisnum; 
           
       }
       
       return answer;
       
       // You're very close! The thing to remember (I'm not sure if I even said this before) is
       //   that when a 'return' is executed, then the function is immediately stopped and control
       //   returns to where the method was called. For example:
       
       /*
        * public static void main(String[] args) {
        *    System.out.println(returnExample());
        * }
        * 
        * public static int returnExample() {
        *    for (int i = 0; i < 10; i++) {
        *       return i;
        *    }
        * }
        */
       
       // Will always print out '0' because in the first time the loop is run (during its first iteration)
       //   the program encounters a return 'statement' and immediately returns. No further things will be
       //   run in that method once a return happens.
       
       // Therefore, the strategy here is to calculate all of the fibonacci numbers that you need to in the
       //   loop and then after the loop is finished (after the ending curly brace of the for loop) return
       //   array that you created.
       
       // For example, this is how you would return an array of length 10 in which every 'element' of the
       //   array contains the number 4:
       
       /*
        * public static int[] makeArray() {
        *     int[] retValue = new int[10];
        * 
        *     for (int i = 0; i < 10; i++) {
        *         retValue[i] = 4;
        *     }
        * 
        *     return retValue;
        * }
        */
       
   }
}
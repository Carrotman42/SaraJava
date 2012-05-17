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
  // int[] answer = new int[10];
   
   
   
       for (int i = 0; i < 10; i++){
           thisnum = lastnum + nextnum;
           lastnum = nextnum;
           nextnum = thisnum;
           System.out.println(thisnum);
          // answer[i] = thisnum; {
       //    System.out.println(answer[i]);
         //  return answer;
           
           }
       }
       
       
       
       return null;
   }
}
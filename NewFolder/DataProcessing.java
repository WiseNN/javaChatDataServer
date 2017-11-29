import java.util.*;



class DataProcessing
{
   DataProcessing()
   {
      //...
   }
   
   public static void main(String[] args)
   {
      DataProcessing op1 = new DataProcessing();
      
      int[] randAry = op1.randomNumberGen();
      System.out.println("Random Ary: "+Arrays.toString(randAry));
   }
   int[] randomNumberGen()
   {
      int[] ary1 = new int[200];
      
      for(int i=0;i<ary1.length;i++)
      {
         
         ary1[i] = (int)(Math.random() * 26);
      }
      
      return ary1;
   }
   
   
   void encrypt(String plainText, int[] randNumAry)
   {
   
   }
}
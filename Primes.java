import java.util.*;

public class Primes {

   // This program prints out the first 100 prime numbers

   public static void main(String[] args) {
      int count = 0;
      int num = 1;
      
      // loop that iterates 100 times
      while (count <= 100) {

         // new variable that keeps track of whether a 
         // given number is prime
         boolean isPrime = true;

         // A number is prime if it is only divisible
         // by 1 and itself.
         for (int div = 2; div < num; div++) {
            if (num % div == 0) { // n is not prime
               isPrime = false;
               div = num;
            }
         }

         // If the number is prime, print it out and
         // increase the count
         if (isPrime) {      
            System.out.println(num + " is prime");
            count++;
         }
         
         // move on to the next num
         num++;
      }
   }
}
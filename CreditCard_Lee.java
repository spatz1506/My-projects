import java.util.Scanner;

public class CreditCard_Lee {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String cardNumber = scanner.nextLine();
        System.out.println("your credit card number: " + cardNumber);

        //verify the card type with first digit of the card number
        if (cardNumber.startsWith("4")) {
            System.out.println("valid card number, Visa card");
        } else if (cardNumber.startsWith("5")) {
            System.out.println("valid card number, MasterCard");
        } else if (cardNumber.startsWith("37")) {
            System.out.println("valid card number,  American Express card");
        } else if (cardNumber.startsWith("6")) {
            System.out.println("valid card number, Discover card");
        } else {
            System.out.println("invalid card number, not a valid card type");
        }

    }
    //adapt luhn algorithm

    //use boolean method to check if the card number is valid or not
    public static boolean isValid(long number) {
        int sum = 0;
        boolean flag = false;
        while (number > 0) {

            // "int" and "number" is in the diffrent data type, number is in long, so we need to cast it to int
            int digit = (int) (number % 10);
            
            //function only when flag is true, which means the digit is in the even place
            if (flag) {
                //same as digit = digit * 2
                digit *= 2;
                //if the doubled digit is two digit number, add first digit and second digit, same as digit = digit / 10 + digit % 10
                if (digit > 9) {
                    // add first digit and second digit, same as digit = digit / 10 + digit % 10
                    digit = digit / 10 + digit % 10;
                }
            }
            //same as sum = sum + digit
            sum += digit;
            //if the flag is true, it will be false and doesn't execute the if statement
            flag = !flag;
            //divide into 10 to get the next digit, same as digit = digit / 10
            number /= 10;
        }
        //if the sum is divisible by 10, the card number is valid
        return sum % 10 == 0;
    }

    //if the number is valid,use int to get the sum of double even place
    public static int sumOfdoubleEvenPlace(long number) {
        int sum = 0;
        boolean flag = false;
        while (number > 0) {
            int digit = (int) (number % 10);
            if (flag) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
                sum += digit;
            }
            flag = !flag;
            number /= 10;
        }
        return sum;
    }
    //use int to get the digit of the number
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }
    //use int to get the sum of odd place
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        boolean flag = false;
        while (number > 0) {
            int digit = (int) (number % 10);
            if (!flag) {
                sum += digit;
            }
            flag = !flag;
            number /= 10;
        }
        return sum;
    }
    //use boolean to check if the prefix matched
    public static boolean prefixMatched(long number, int d) {
        String numStr = Long.toString(number);
        String prefixStr = Integer.toString(d);
        return numStr.startsWith(prefixStr);
    }
    //use int to get the size of the number
     public static int getSize(long d) {
        return Long.toString(d).length();
    }
    //use long to get the prefix of the number
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        if (numStr.length() < k) {
            return number;
        } else {
            return Long.parseLong(numStr.substring(0, k));
        }
    }
}

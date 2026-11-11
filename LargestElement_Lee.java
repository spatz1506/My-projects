import java.util.Scanner;

public class LargestElement_Lee {
    public static void main(String[] args) {

        //create a Scanner to take input about the size of the 2D array
        Scanner input = new Scanner(System.in);

        //prompt the user to enter the size of the 2D array
        System.out.println("Enter the number of the row and column: ");
        String row = input.next();  
        String column = input.next();
        System.out.println("row size is: " + row + "/ column size is: " + column + " Size of the 2D array is: " + row + " x " + column + " = " + (Integer.parseInt(row) * Integer.parseInt(column)));
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Now enter the numbers for the Array table, " + "You can enter " + (Integer.parseInt(row) * Integer.parseInt(column)) + " numbers");

        //create a 2D array with the size of row and column
        //use double array to store the elements of the 2D array
        //use "Integer.parseInt()" to convert the string to integer
        double[][] array = new double[Integer.parseInt(row)][Integer.parseInt(column)];
        
        //two integer for each row and column to store the largest element's location
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] =input.nextDouble();
            }
        }

         System.out.println("\n--- Array table ---");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++){
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("----------------------\n");

       returnLargest(array);

    }
    
    //create a method to locate the largest element in the 2D array
    public static void returnLargest(double[][] array) {
        double largest = array[0][0];
        int largestRow = 0;
        int largestColumn = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > largest) {
                    largest = array[i][j];
                    largestRow = i;
                    largestColumn = j;
                }
            }
        }

        System.out.println("The largest element is " + largest);
        System.out.println("It is located at (row: " + largestRow + ", column: " + largestColumn + ")");
    }
    
}

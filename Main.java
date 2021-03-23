import java.util.Scanner;

/**
 * Binary to Decimal calculator
 * @author Anmol
 */
public class Main {

    // Calculates a decimal from a Binary
    public static double binaryToDec(int binary) {

    // Declare and initialize all the 
    int binary2 = binary;
    double answer;

    int[] binaryNum = new int[7];
    double[] binaryValue = new double[7];
    int[] mathBinary = {6, 5, 4, 3, 2, 1, 0};
    double[] decimalNum = new double[7];

    // List all the binary numbers in the right order in an array
    for (int i = 6; i > -1; i--) {
      int lastNum = binary2%10;
      binaryNum[i] = lastNum;
      binary2 = binary2/10;
    }

    // List all the Values of the binary numbers in the order. (so arr binaryNum marches arr binaryValue)
    for (int i = 6; i > -1; i--) {
      binaryValue[i] = Math.pow(2, mathBinary[i]);
    }

    // Multiply both arrays with one another, so if the value is 0, the decimal for it will be 0 too since number x 0 is 0.
    for (int i = 0; i < 7; i++) {
      decimalNum[i] = binaryValue[i]*binaryNum[i];
    }

    // Add all the numbers up.
    answer = decimalNum[0] + decimalNum[1] + decimalNum[2] + decimalNum[3] + decimalNum[4] + decimalNum[5] + decimalNum[6];

    return answer;
  }

  /**
   * The method that is executed when you hit the run button.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // create a Scanner for user input
    Scanner input = new Scanner(System.in);

    // Ask the user for a number
    System.out.println("Type a binary");
    int num = input.nextInt();

    // Call for the firstdigit function, and see the results
    double answer = binaryToDec(num);
    System.out.println(answer); 
  }
}

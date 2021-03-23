import java.util.Scanner;
import java.util.Arrays;

/**
 * Binary to base 10 convertor
 * 
 * @author Anmol
 */
public class Main {

  // Calculates a decimal from a Binary
  public static double binaryToDec(int binary) {

    // Declare and initialize all the
    int charLength = 0;
    int binary2 = binary;
    int binary3 = binary;
    double answer = 0;
    int stop = 1;

    // This will figure out how many numbers the binary has
    while (stop == 1) {
      // Checks if the integer is 0, and will stop the loop
      if (binary3 < 1) {
        stop = 0;
        break;
      }
      // Will remove one number per run, until there are no numbers
      binary3 = binary3 / 10;
      charLength++;
    }

    // Creating all the arrays for the functiom
    int[] binaryNum = new int[charLength];
    double[] binaryValue = new double[charLength];
    int[] mathBinary = new int[charLength];
    double[] decimalNum = new double[charLength];

    // This will make an array that will count up to the amount of digits the binary
    // has.
    for (int i = charLength - 1; i > -1; i--) {
      mathBinary[i] = i;
    }

    // This will make the counting up array, to flip since we wanna make the
    // expononemt of 2 the biggest number first.
    for (int i = 0; i < mathBinary.length / 2; i++) {
      int temp = mathBinary[i];
      mathBinary[i] = mathBinary[mathBinary.length - i - 1];
      mathBinary[mathBinary.length - i - 1] = temp;
    }

    // List all the binary numbers in the right order in an array
    for (int i = charLength - 1; i > -1; i--) {
      int lastNum = binary2 % 10;
      binaryNum[i] = lastNum;
      binary2 = binary2 / 10;
    }

    // List all the Values of the binary numbers in the order. (so arr binaryNum
    // marches arr binaryValue)
    for (int i = charLength - 1; i > -1; i--) {
      binaryValue[i] = Math.pow(2, mathBinary[i]);
    }

    // Multiply both arrays with one another, so if the value is 0, the decimal for
    // it will be 0 too since number x 0 is 0.
    for (int i = 0; i < charLength; i++) {
      decimalNum[i] = binaryValue[i] * binaryNum[i];
    }

    // Add all the numbers up.
    for (int i = 0; i < charLength; i++) {
      answer = answer + decimalNum[i];
    }

    return answer;
  }

  /**
   * The method that is executed when you hit the run button.
   * 
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

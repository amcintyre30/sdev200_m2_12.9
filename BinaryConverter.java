/**
 * Author: Aubrie McIntyre
 * Date: 8/30/2024
 * Description: Checks if a string is a binary string or not.
 */

 // Define a custom exception class
 class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
 }

 public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the input string is a valid binary string
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert the binary string to decimal
        int decimal = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        try {
            String binaryString = "1010101";
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal value: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 }
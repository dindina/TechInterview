package arrays;

public class BinaryToZero {
    public static int countOperations(String binaryString) {
        int count = 0;
        int i = 0;
        while (i < binaryString.length()) {
            if (binaryString.charAt(i) == '1') {
                count++;
                i++;
                while (i < binaryString.length() && binaryString.charAt(i) == '0') {
                    i++;
                }
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String binaryString = "10010111";
        int count = countOperations(binaryString);
        System.out.println("The number of operations needed to get the binary string to zero is: " + count);
    }
}

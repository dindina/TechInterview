package bitmanipulation;

public class FindTwoNumbersWithoutPair {



    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        System.out.print("Missing number is: " + FindTwoNumbersWithoutPair.findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {

        int x1 = 0;
        for(int i=0 ; i < arr.length ; i++) {
            x1 = x1 ^ arr[i];
       }
        // do something with the x1



        return x1;
    }
}

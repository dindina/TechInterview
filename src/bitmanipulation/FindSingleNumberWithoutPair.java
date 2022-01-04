package bitmanipulation;

public class FindSingleNumberWithoutPair {



    public static void main(String[] args) {
        int[] arr = new int[] {1,3,3,4,4,1,5,5,6};
        System.out.print("Missing number is: " + FindSingleNumberWithoutPair.findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {

        int x1 = 0;
        for(int i=0 ; i < arr.length ; i++) {
            x1 = x1 ^ arr[i];
       }

        return x1;
    }
}

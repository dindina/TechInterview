package bitmanipulation;

public class FindMissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length;

        int x2 = n;
        for (int i = 0; i < n; i++) {
            x2 = i^x2 ^ arr[i];
        }

        return x2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,3,2,5,6};
        System.out.print("Missing number is: " + FindMissingNumber.findMissingNumber(arr));
    }
}

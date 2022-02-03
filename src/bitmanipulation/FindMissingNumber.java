package bitmanipulation;

public class FindMissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;


        int x2 = arr[0];
        for (int i = 1; i < n-1; i++)
        {
            //System.out.print("xor  "+ x2 + ", " + arr[i]);
            x2 = x2 ^ arr[i];
            //System.out.println(" = " + x2);
        }
        //System.out.println("x2 is " + x2);


        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            //System.out.print("xor  "+ x1 + ", " + i);
            x1 = x1 ^ i;
            //System.out.println(" = " + x1);
        }
        //System.out.println("x1 is " + x1);



        return x1^x2;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3};
        System.out.print("Missing number is: " + FindMissingNumber.findMissingNumber(arr));
    }
}

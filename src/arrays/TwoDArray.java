package arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] twod = new int[][]{
                {1,2},
                {3,4},
                {5,6}
        };

        for(int [] array : twod)
        {
            System.out.println(array[0]);
            System.out.println(array[1]);
        }

    }
}

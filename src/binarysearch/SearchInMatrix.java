package binarysearch;
/*
https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

 */
public class SearchInMatrix {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
      };
        System.out.println(new SearchInMatrix().searchMatrix(array,1));
        System.out.println(new SearchInMatrix().searchMatrix(array,3));
        System.out.println(new SearchInMatrix().searchMatrix(array,7));
        System.out.println(new SearchInMatrix().searchMatrix(array,34));


    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0; i< row;i++)
        {
            // check if the number exists in the current row
            if(target>= matrix[i][0] || target <= matrix[i][col-1] )
            {
                // start the binary search in the current row
                int left = 0;
                int right = col-1;
                while(left <= right)
                {
                    int mid = left + (right-left)/2;
                    if( target == matrix[i][mid])
                        return true;
                    if( target > matrix[i][mid])
                    {
                        left = mid+1;
                    }
                    else
                    {
                        right=mid-1;
                    }

                }

            }
        }
        return false;

    }
}

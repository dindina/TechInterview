package apple.practice;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrix2 = new int[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        };
        int i = matrix1.length; // rows
        int j = matrix1[0].length; // column
        int m = matrix2[0].length; // column
        int[][] result = new int[i][m];

        // traverse matrix along each row
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                // traverse the matrix2 along the columns, keeping row as fixed
                for (int x = 0; x < m; x++)
                    result[a][x] += matrix1[a][b] * matrix2[b][x];
            }
        }
        for (int a = 0; a < i; a++)
            for (int b = 0; b < m; b++)
                System.out.println(result[a][b]);
    }

}

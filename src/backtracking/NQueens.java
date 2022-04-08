package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

 */
public class NQueens {
    public static void main(String[] args) {
        int n=4;
        System.out.println(new NQueens().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[1][1];
        for(int i=0 ; i< n ; i++)
            for(int j=0 ; j< n ; j++)
        {
            board[i][j] = '.';
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        int col=0;

        backtrack_queen(col,board,leftRow,upperDiagonal,lowerDiagonal,n,result);

        return result;

    }

    private void backtrack_queen(int col, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int n, List<List<String>> result) {

        if(col==n)
        {
            result.add(construct(board));
            return;
        }

        for(int row=0; row<board.length;row++)// iterate every row and set every column
        {
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length -1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                lowerDiagonal[col + row] = 1;
                backtrack_queen(col + 1, board, leftRow, upperDiagonal, lowerDiagonal, n, result);
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
                lowerDiagonal[col + row] = 0;
            }
        }
        
        

    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i=0 ; i < board.length;i++)
        {
            System.out.println(board[i]);
            res.add(new String(board[i]));
        }
        return res;
    }


}

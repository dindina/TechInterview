package backtracking;
/*
https://leetcode.com/problems/sudoku-solver/
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        new SudokuSolver().solveSudoku(board);

        int count=0;
        for (char[] array : board)
        {
            System.out.println(board[count++]);
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudoku_bridge(board);
    }

    public boolean solveSudoku_bridge(char[][] board) {
        for(int i=0 ; i < board.length ; i++)
            for(int j=0; j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                     for(char number='1' ; number <='9'; number++ )
                    {
                        if(isValidChar(board,i,j,number))
                        {
                            board[i][j]=number;
                            if(solveSudoku_bridge(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }



            }
        return true;

    }

    private boolean isValidChar(char[][] board , int row, int col , char ch) {
        for(int i=0;i<9;i++)
        {
            // check the row
            if(board[row][i]==ch) return false;
            // check the col
            if(board[i][col]==ch) return false;

            // check the 3*3 box
            if( board[3*(row/3)+i/3][3*(col/3)+i%3] == ch  ) return false;

        }
        return true;

    }


}

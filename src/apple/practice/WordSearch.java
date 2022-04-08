package apple.practice;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'}
                ,{'S','F','C','S'}
                ,{'A','D','E','E'}
        };
        String word = "ABCB";
        System.out.println(new WordSearch().exist(board,word));

    }

    public boolean exist(char[][] board, String word) {

        int count=0;
        for(int i=0 ;i <board.length;i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    return dfs_wordsearch(board,i,j,count,word);
                }
            }
        }
        return false;
    }

    private boolean dfs_wordsearch(char[][] board, int i, int j, int count, String word) {
        if(count == word.length())
            return true;

        if(i<0 || j <0 || i>=board.length || j>=board[0].length || word.charAt(0)!=board[i][j]) return false;

        char temp = board[i][j];
        board[i][j]=' ';

        boolean found = dfs_wordsearch(board,i,j,count+1,word) ||
                dfs_wordsearch(board,i-1,j,count+1,word)||
                dfs_wordsearch(board,i,j+1,count+1,word)||
                dfs_wordsearch(board,i,j-1,count+1,word);

        board[i][j]=temp;
        return found;

    }
}

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
        //System.out.println(new WordSearch().exist(board,word));
    }


}
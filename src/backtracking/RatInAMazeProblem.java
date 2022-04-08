package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeProblem {
    public static void main(String[] args) {
        int[][]maze = new int[][]{
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };

            System.out.println(new RatInAMazeProblem().allPath(maze));
    }

    private List<StringBuilder> allPath(int[][] maze) {
        List<StringBuilder> result = new ArrayList<>();
        if(maze[0][0] !=1 ) return result;
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        int [][] directions  = new int[][] //DRUL
                {
                        {1,0},
                        {0,1},
                        {-1,0},
                        {0,-1}
                };
        rat_backtrack(0,0,maze,result,new StringBuilder(),visited,directions);
        return result;
    }

    private void rat_backtrack(int i, int j, int[][] maze,
                               List<StringBuilder> result, StringBuilder stringBuilder,
                               boolean[][] visited, int[][] directions) {
        if(i== maze.length-1 && j== maze[0].length-1) {
            result.add(new StringBuilder(stringBuilder));
            return;
        }
        String moves="DRUL";
        for(int index=0; index < 4; index++)
        {
                int newrow = i+directions[index][0];
                int newcol = j+directions[index][1];
                if(newrow <0 || newcol <0 || newrow >= maze.length || newcol >= maze[0].length
                        || visited[newrow][newcol]== true || maze[newrow][newcol]==0) continue;
                    visited[newrow][newcol] = true;
                    rat_backtrack(newrow, newcol, maze, result, stringBuilder.append(moves.charAt(index)), visited, directions);
                    visited[newrow][newcol] = false;
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }

        }

    }

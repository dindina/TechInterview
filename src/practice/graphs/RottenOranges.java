package practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 */
public class RottenOranges {
    int count=0;
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{
                {1,0},
                {0,1},
                {-1,0},
                {0,-1}
        };
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        int fresh=0;
        int rotten=0;
        Queue<Integer[]>  queue = new LinkedList<>();
        for(int i=0 ;i< grid.length;i++)
        {
            for(int j=0; j< grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                else if (grid[i][j]==2)
                {
                    rotten++;
                    visited[i][j]=true;
                    queue.offer(new Integer[]{i,j});
                }
            }
        }

        System.out.println("fresh " + fresh);
        System.out.println("rotten " + rotten);
        if(rotten==0) return -1;

        int timeElapsed=-1;
        while(!queue.isEmpty())
        {
           int size = queue.size();
           for(int i=0 ; i<size;i++)
           {
               Integer[] item = queue.poll();
               for(int[] array : directions)
               {
                    int newrow = item[0]+array[0];

                    int newcol = item[1]+array[1];
                    if(newrow >=0 && newcol>=0 && newrow < grid.length && newcol < grid[0].length && !visited[newrow][newcol])
                   {
                       visited[newrow][newcol]=true;
                       if(grid[newrow][newcol]==1)
                       {
                           grid[newrow][newcol]=2;
                           fresh--;
                           rotten++;
                           queue.offer(new Integer[]{newrow,newcol});
                       }
                   }
               }

           }
            timeElapsed++;

        }
        System.out.println("timeElapsed" +timeElapsed);
        System.out.println("fresh" +fresh);
        System.out.println("rotten" +rotten);
        return fresh ==0 ? timeElapsed:-1;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {2,1,1},
                        {1,1,0},
                        {0,1,1}
                };

        System.out.println(new RottenOranges().orangesRotting(grid));
    }
}

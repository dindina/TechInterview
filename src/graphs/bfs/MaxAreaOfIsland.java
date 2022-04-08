package graphs.bfs;
/*
https://leetcode.com/problems/max-area-of-island/
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.


 Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6

 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i< grid.length; i++)
            for(int j=0; j< grid[0].length;j++)
            {
                count = Math.max(count,getArea(grid,i,j,visited));
            }
        return count;
    }

    private int getArea(int[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 || j<0 || i>= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j]==0) return 0;

        visited[i][j]=true;

        return (1 + getArea(grid,i+1,j,visited) + getArea(grid,i-1,j,visited)
        + getArea(grid,i,j+1,visited) + getArea(grid,i,j-1,visited));
    }

}

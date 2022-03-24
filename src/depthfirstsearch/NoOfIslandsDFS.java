package depthfirstsearch;

import graphs.bfs.IslandProblemBFS;

public class NoOfIslandsDFS {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new IslandProblemBFS().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for(int i=0 ; i< row ; i++)
            for(int j= 0; j< col; j++)
            {
                result++;
                dfs_islands(grid,row,col);
            }

        return result;

    }

    private void dfs_islands(char[][] grid, int row, int col) {
        int gridrow = grid.length;
        int gridcol = grid[0].length;

        if(row <0 || col <0 || row>gridrow || col > gridcol || grid[row][col]=='0' )
            return;
        System.out.println("visiting row ="+row + ", col=" +col);
        grid[row][col]='0';
        dfs_islands(grid,row+1,col);
        dfs_islands(grid,row-1,col);
        dfs_islands(grid,row,col+1);
        dfs_islands(grid,row,col-1);
    }
}

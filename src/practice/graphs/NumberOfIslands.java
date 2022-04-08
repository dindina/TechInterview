package practice.graphs;

public class NumberOfIslands {

    public static void main(String[] args) {


        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    private int numIslands(char[][] grid) {
        int count=0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i< grid.length;i++)
        {
            for(int j=0; j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs_dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    private void dfs_dfs(int row, int col, char[][] grid, boolean[][] visited) {

        if(row <0 || col <0 || row >=grid.length || col >=grid[0].length || visited[row][col]) return;

        visited[row][col]=true;
        grid[row][col]='0';
        dfs_dfs(row+1,col,grid,visited);
        dfs_dfs(row-1,col,grid,visited);

        dfs_dfs(row,col+1,grid,visited);

        dfs_dfs(row,col-1,grid,visited);

    }
}

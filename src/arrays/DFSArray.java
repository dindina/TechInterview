package arrays;

public class DFSArray {

    public static void main(String[] args) {
        int [][] twod = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };

        TraverseDFS(twod);
    }

    private static void TraverseDFS(final int[][] twod) {
        int directions[][] = new int[][]{
                {-1,0},//up
                {0,1},//right
                {1,0},//down
                {0,-1},//left
        };
        boolean visited[][] = new boolean[twod.length][twod[0].length];
        dfs(twod,0,0,visited,directions);


    }

    private static void dfs(final int[][] twod, int row,int col , final boolean[][] visited, final int[][] directions) {
        System.out.print(twod[row][col] + "->");
        visited[row][col] = true;
        for (int i=0; i < directions.length; i++)
        {
            int[] pair = directions[i];
            int newRow = row + pair[0];
            int newCol = col + pair[1];
            if(newRow<0 || newCol < 0 || newRow >= twod.length || newCol >= twod[0].length)
                continue;
            if(!visited[newRow][newCol])
                dfs(twod,newRow,newCol,visited,directions);
        }
    }
}

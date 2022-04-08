package backtracking;

public class PathExistDFS {
    public static void main(String[] args) {
        int [][] edges = new int[][]
                {
                        {1},{2,3},{4} ,{5},{5},{6},{}
                };
        System.out.println(new PathExistDFS().pathExists(7,edges,2,0));
    }



    public boolean pathExists(int max , int[][] edges , int source , int destination)
    {
        boolean[] visited = new boolean[max];
        dfs_path_exist(edges,source,visited);
        return visited[destination];
    }

    private void dfs_path_exist(int[][] edges, int source, boolean[] visited) {
        visited[source] = true;
        int[] neighbours = edges[source];
        for(int n  :neighbours)
        {
            if(!visited[n])
            dfs_path_exist(edges,n,visited);
        }
    }

}

package graphs;



public class DetectCycleDFS {

    public boolean isCycle(int max, int[][] edges)
    {
        boolean result = false;
        int visited[] = new int[max];
        int pathVisited[] = new int[max];
        for(int i=0 ; i< max ; i++)
        {
            if(visited[i]==0) {
                if (dfs_cycle(i, edges, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return result;

    }

    private boolean dfs_cycle(int i, int[][] edges, int[] visited,int [] pathVisited) {

        visited[i] = 1;
        pathVisited[i] = 1;
        int[] neighbours = edges[i];
        for(int nei : neighbours)
        {
            if(visited[nei] ==0) {
                if (dfs_cycle(nei, edges, visited, pathVisited))
                    return true;
            } else if(pathVisited[i]==1){
                return true;
            }
        }

        pathVisited[i]=0;
        return false;
    }


    public static void main(String[] args) {
        int[][]edges = new int[][]{ {1},{3},{0},{2}};
        //System.out.println(edges[0]);
        System.out.println(new DetectCycleDFS().isCycle(4,edges));
    }
}

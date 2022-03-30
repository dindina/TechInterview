package graphs;



public class DetectCycle {

    public boolean isCycle(int max, int[][] edges)
    {
        boolean result = false;
        int visited[] = new int[max];
        for(int i=0 ; i< max ; i++)
        {
            if(!dfs_cycle(i,edges,visited)) {
                for(int k : visited)
                    System.out.println(k);
                return true;
            }
        }
        for(int i : visited)
            System.out.println(i);
        return result;

    }

    private boolean dfs_cycle(int i, int[][] edges, int[] visited) {

        if(visited[i] ==-1 ) return false;

        if(visited[i] ==1 ) return true;

        visited[i] = -1;

        int[] neighbours = edges[i];
        for(int nei : neighbours)
        {
            if (!dfs_cycle(nei,edges,visited))
                return false;
        }

        visited[i]=1;
        return true;
    }


    public static void main(String[] args) {
        int[][]edges = new int[][]{ {1},{3},{0},{2}};
        //System.out.println(edges[0]);
        System.out.println(new DetectCycle().isCycle(4,edges));
    }
}

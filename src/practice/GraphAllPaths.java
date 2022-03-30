package practice;

import java.util.ArrayList;
import java.util.List;

public class GraphAllPaths {
    public static void main(String[] args) {
        int [][] edges = new int[][]
                {
                        {1},{2,3},{4} ,{5},{5},{6},{}
                };

        System.out.println(new GraphAllPaths().allpaths(7,edges,0,5));
        //System.out.println(new GraphAllPaths().pathExists(7,edges,2,0));
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
    private List<List<Integer>> allpaths(int max, int[][] edges, int source , int destination) {

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(source);
        int visited[] = new int[max];
        backktraak(source,destination,edges,result,path,visited);

        return result;
    }

    private boolean backktraak(int s, int d, int[][] edges, List<List<Integer>> result
            , ArrayList<Integer> objects , int[] visited) {

        if(visited[s] ==-1)
            return false;

        if(visited[s] ==1)
            return true;
        if(s==d) {
            result.add(new ArrayList<>(objects));

        }
        visited[s]=-1;
        int[] neighbours = edges[s];
        for(int n : neighbours)
        {

            objects.add(n);
            if(!backktraak(n,d,edges,result,objects,visited)) return false;
            objects.remove(objects.size()-1);
        }
        visited[s]=1;
        return true;
    }
}

package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphPathFromSourceToDestination {
    public static void main(String[] args) {
        int [][] edges = new int [][]{
                {0,1},{1,2},{2,0}
        };
        int source = 0;
        int destination =2;
        System.out.println(new GraphPathFromSourceToDestination().paths(edges,source,destination));
    }

    private List<List<Integer>> paths(int[][] edges, int source, int destination) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(source);
        backtrack(edges,path,result,source,destination);
        return result;
    }

    private void backtrack(int[][] edges, ArrayList<Integer> path, List<List<Integer>> result, int source, int destination) {

        if(source == destination) {
            result.add(new ArrayList<>(path));
            return;
        }
        int[] neighbours = edges[source];
        for(int i : neighbours)
        {
            if(!path.contains(i)) {
                path.add(i);
                backtrack(edges, path, result, i, destination);
                path.remove(path.size() - 1);
            }
        }
    }
}

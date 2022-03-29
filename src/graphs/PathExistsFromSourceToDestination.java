package graphs;

import java.util.ArrayList;
import java.util.List;

public class PathExistsFromSourceToDestination {
    public static void main(String[] args) {
        int [][] edges = new int [][]{
                {1,2},{3},{3},{4},{5}
        };
        int source = 0;
        int destination =5;
        System.out.println(new PathExistsFromSourceToDestination().paths(edges,source,destination));
    }

    private boolean paths(int[][] edges, int source, int destination) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(source);
        return backtrack(edges,source,destination , new ArrayList<>());
        //return result;
    }

    public boolean backtrack( int [][] edges , int s , int d , ArrayList<Integer> path)
    {
        if(s == d )
            return true;

        int [] neighbours = edges[s];
        for(int i : neighbours )
        {
            path.add(i);
            return backtrack(edges,i,d,path);
            //path.remove(path.size()-1);
        }
        return false;
    }
}

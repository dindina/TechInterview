package graphs;

import java.util.ArrayList;
import java.util.List;


//given edges how to buold a graph
public class BuildGraph {

    public static void main(String[] args) {
        int [][] edges = new int [][]{
                {0,2},{1,2},{0,3},{3,1},{2,3}
        };

        System.out.println(new BuildGraph().buildGraph1(4,edges));
        System.out.println(new BuildGraph().buildGraph2(4,edges));
    }

    private List<Integer>[] buildGraph1(final int n, final int[][] edges) {

        List<Integer>[] graph = new List[n];
        for(int i= 0; i<n ; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge :edges)
        {
            graph[edge[0]].add(edge[1]);
        }

        return graph;

    }

    private List<List<Integer>> buildGraph2(final int n, final int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i < n ; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;

    }
}

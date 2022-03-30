package graphs;

import java.util.ArrayList;
import java.util.List;

/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
public class FindIfPathExistsDFS {

    public boolean validPath(int max, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i< max ; i++) // init the graph
        {
            graph.add(new ArrayList<>());
        }
        for(int [] array : edges)
        {
            graph.get(array[0]).add(array[1]);
            graph.get(array[1]).add(array[0]);
        }
        System.out.println(graph);

        boolean[] visited = new boolean[max];
        dfspath(graph,visited,source);

        if(visited[destination]) return  true;
        return false;


    }

    //10
    //[[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]]
    //7
    //5
    // output [[7, 8, 4], [3], [0], [5], [7], [8], [1, 5], [], [], []]

    private void dfspath(List<List<Integer>> graph, boolean[] visited, int source) {

        visited[source]=true;
        List<Integer> neighbours = graph.get(source);
         for(Integer neighbour : neighbours)
        {
            if(!visited[neighbour])
            dfspath(graph,visited,neighbour);
        }
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,0}};
        System.out.println(new FindIfPathExistsDFS().validPath(3,edges,0,2));
    }
}

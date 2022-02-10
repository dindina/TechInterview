package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.



Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
 */


public class FindIfPathExists {

    class Graph
    {
        List<List<Integer>>  edges = new ArrayList<>();
        int total;
        boolean visited[];

        Graph(int max)
        {
            total=max;
            visited = new boolean[max];
            Arrays.fill(visited,false);
            for(int i=0; i <total; i++)
            {
                edges.add(i,new ArrayList<>());
            }
        }

        public void addEdge(int x,int y)
        {
            edges.get(x).add(y);
        }

        public boolean isConnected(int source , int destination)
        {
            dfs(source);
            return visited[destination];

        }

        private void dfs(final int source) {
            visited[source] = true;
            List<Integer> connections = edges.get(source);
            for(int i :connections)
            {
                if(!visited[i])
                    dfs(i);
            }
        }

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(destination > n)
            return false;
        Graph graph = new Graph(n);
        for(int i=0 ; i <edges.length; i++)
            graph.addEdge(edges[i][0] , edges[i][1]);

        return graph.isConnected(source,destination);




    }

    public static void main(String[] args) {
        int [][] edges = new int [][]{
                {0,1},{0,2},{3,5},{5,4},{4,3}
        };
        System.out.println(new FindIfPathExists().validPath(6,edges,0,5));
    }

}

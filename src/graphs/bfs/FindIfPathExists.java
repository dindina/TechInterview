package graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
 */
public class FindIfPathExists {

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                { 0, 1 }, { 1, 2 }, { 3, 5 },{5,4},{4,3}
        };
        new FindIfPathExists().validPath(6,edges,0,5);
    }

        public boolean validPath(int n, int[][] edges, int source, int destination) {

            //
            List<List<Integer>> graph = new ArrayList<>();
            // intialize the graph
            for(int i=0; i < n ; i++)
            {
                graph.add(new ArrayList<>());
            }
            //System.out.println(graph);
            // convert edges to the adj list or the graph
            for(int [] edge  : edges)
            {
                graph.get(edge[0]).add(edge[1]);
            }
            System.out.println(graph);

            Queue<Integer> queue = new LinkedList<>();
            boolean [] visited = new boolean[n];
            queue.offer(source);
            //visited[source] = true;
            List<Integer> path = new ArrayList<>();

            while(!queue.isEmpty()) {
                int element = queue.poll();
                path.add(element);
                if(element == destination)
                    break;
                visited[element] = true;
                // find the neighbours
                List<Integer> neighbours = graph.get(element);
                for(int i : neighbours)
                {
                    if(!visited[i])
                    {
                        queue.offer(i);
                    }
                }
            }

            return true;
     }

}

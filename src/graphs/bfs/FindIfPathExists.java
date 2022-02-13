package graphs.bfs;

import java.util.*;


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
                {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
        };
        System.out.println(new FindIfPathExists().validPath(10,edges,7,5));
        System.out.println(new FindIfPathExists().validPath1(10,edges,7,5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

            if(n==1)
                 return true;
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
                graph.get(edge[1]).add(edge[0]);
            }
            System.out.println(" my " + graph);

            Queue<Integer> queue = new LinkedList<>();
            boolean [] visited = new boolean[n];
            queue.offer(source);
            visited[source] = true;
            List<Integer> path = new ArrayList<>();

            while(!queue.isEmpty()) {
                int element = queue.poll();
                path.add(element);
                System.out.println("path " + path);
                if(element == destination)
                    return true;

                // find the neighbours
                List<Integer> neighbours = graph.get(element);
                for(int i : neighbours)
                {
                    if(!visited[i])
                    {
                        queue.offer(i);
                        visited[element] = true;
                    }
                }
            }
            if(path.contains(destination) && path.size()>1)
                return true;
            else
                return false;
     }

    public boolean validPath1(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        System.out.println(" theirs " + adjacency_list);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        seen[start] = true;

        while (!queue.isEmpty()) {
            // Get the current node.
            int node = queue.poll();

            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

}

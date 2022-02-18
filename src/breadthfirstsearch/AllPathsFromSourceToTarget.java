package breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
                //{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
                {0,1},{0,4},{0,2},{2,3},{3,4}
        };

        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(edges));

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {

        List<List<Integer>> paths = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();

        // init the graph
        for(int i=0 ;i < edges.length; i++)
        {
            graph.add(new ArrayList<>());
        }
        // set the edges in the graph

        for (int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        System.out.println(graph);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        queue.offer(0);
        visited[0]=true;
        List<Integer> path = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            path.add(node);
            List<Integer> neighbours  = graph.get(node);
            for(Integer neighbour : neighbours)
            {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println(path);

        return paths;




    }
}

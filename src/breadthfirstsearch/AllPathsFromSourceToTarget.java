package breadthfirstsearch;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
                //{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
                {0,1},{0,4},{0,2},{2,3},{3,4}
        };
        System.out.println("hello");
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(edges));

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {

        List<List<Integer>> paths = new ArrayList<>();

        /*List<List<Integer>> graph = new ArrayList<>();

        // init the graph
        for(int i=0 ;i < edges.length; i++)
        {
            graph.add(new ArrayList<>());
        }
        // set the edges in the graph

        for (int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }*/

        //System.out.println(graph);

        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(Arrays.asList(0)); // zero edge

        int destination = edges.length-1;
        while(!queue.isEmpty())
        {
            List<Integer> path = queue.poll();
            int current = path.get(path.size()-1);
            if(current == destination)
            {
                paths.add(new ArrayList<>(path));
            }
            else // find the neighbours
            {
                int[] neighbours = edges[current];
                for(int n : neighbours)
                {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(n);
                    queue.offer(list);
                }

            }
        }
        //System.out.println(path);

        return paths;




    }
}

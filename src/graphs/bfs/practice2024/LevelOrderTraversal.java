package graphs.bfs.practice2024;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        int[][] edges = new int[][]{
                {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
        };
        int vertice = 10 ;
        int src = 1 ;
        int dest = 2 ;
        System.out.println(levelOrderTraversal(edges,vertice));
    }

    static List<List<Integer>> levelOrderTraversal (int [][] edges, int total)
    {
        List<List<Integer>> paths = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        // create the unidirected graph

        for(int i=0 ; i< total ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int []edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }
        System.out.println(graph);

        //return null;

        Queue<List<Integer>> queue = new LinkedList<>();
        System.out.println("root " + graph.get(0));
        queue.offer(graph.get(0)); // first element;
        while(!queue.isEmpty())
        {
            List<Integer> current = queue.peek();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<current.size() ; i++)
            {
                level.add(current.get(i));
                System.out.println(level);
                for(Integer nighbor : current)
                {
                    queue.offer(graph.get(nighbor));
                }
            }
            paths.add(level);

        }
        //System.out.println("visted " + visited);
        return paths;
    }

}

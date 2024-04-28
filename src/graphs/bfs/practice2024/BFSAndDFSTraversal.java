package graphs.bfs.practice2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSAndDFSTraversal {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
        };
        int vertice = 10 ;
        Set<Integer> path = bfs(vertice,edges);
        System.out.println("bfs path " +path);

        path = dfs(vertice,edges);
        System.out.println("dfs path " +path);
    }



    public static Set<Integer> dfs(int total , int [][]edges)
    {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ;i<total;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            //graph.get(edge[1]).add(edge[0]); this is for a bi directional graph
        }

        dfsHelper(graph,visited,0);
        return visited;
    }

    public static void dfsHelper(List<List<Integer>> graph , Set<Integer> visited , int curr)
    {
        visited.add(curr);
        for(Integer temp : graph.get(curr))
        {
            if(!visited.contains(temp))
            {
                visited.add(temp);
                dfsHelper(graph,visited,temp);
            }
        }
    }

    static Set<Integer> bfs(int total , int [][] edges)
    {
        // create graph from  the edge
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ;i<total;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            //graph.get(edge[1]).add(edge[0]); this is for a bi directional graph
        }
        System.out.println(graph);


        Set<Integer> visited = new HashSet<>();
        Queue<Integer>queue = new LinkedList<>();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            for(Integer neighbor : graph.get(curr))
            {
                if(!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visited;

    }





}

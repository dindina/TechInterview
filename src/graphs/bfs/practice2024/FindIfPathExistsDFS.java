package graphs.bfs.practice2024;

import java.util.*;

public class FindIfPathExistsDFS {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
        };
        int vertice = 10 ;
        int src = 1 ;
        int dest = 2 ;
        System.out.println(validPath(vertice,edges,src,dest));



    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfsHelper(graph,visited,source);
        System.out.println("path " + visited);
        if(visited.contains(destination))
        {
            return true;
        }
        else
        {
            return false;
        }

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
}

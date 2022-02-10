package graphs;

import java.util.ArrayList;
import java.util.List;


/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]


 */
public class AllPathsFromSourceToDestination {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> allpaths = new ArrayList<>();
        dfs(graph , 0 , new ArrayList<>() , allpaths);
        return allpaths;
    }

    void dfs(int [][] graph , int sourceNode , List<Integer> path , List<List<Integer>> allpaths)
    {
        path.add(sourceNode);
        if(sourceNode == graph.length-1) // this means we have a path
        {
            allpaths.add(new ArrayList<>(path));
            return;
        }

        //find the neighbours from the given node
        int [] neighbors = graph[sourceNode];
        for(int neighbor : neighbors) {
            dfs(graph, neighbor, path, allpaths);
            path.remove(path.size() - 1);
        }


    }

    public static void main(String[] args) {
        int [][] edges = new int [][]{
                {1,2},{3},{3},{}
        };

        System.out.println(new AllPathsFromSourceToDestination().allPathsSourceTarget(edges));
    }

}

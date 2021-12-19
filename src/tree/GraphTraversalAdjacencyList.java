package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Graph_Adj
{
    private int verticeCount;
    private LinkedList<Integer>[] adj;

    //constructor

    Graph_Adj(int v)
    {
        verticeCount = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int v , int w)
    {
        adj[v].add(w);
    }

    void DFSUtil(int v , boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> iterator = adj[v].listIterator();
        while(iterator.hasNext())
        {
            int current = iterator.next();
            if(!visited[current])
                DFSUtil(current,visited);

        }

    }
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[verticeCount];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
        System.out.println();
    }
    void BFS(int node)
    {
        Queue<Integer> nodesToVisit = new ArrayDeque<>();
        boolean visited[] = new boolean[verticeCount];
        //visited[node] = true;
        nodesToVisit.offer(node);

        while(nodesToVisit.size() > 0)
        {
            int current = nodesToVisit.poll();
            System.out.print(current + " ");
            visited[current]=true;
            // add the elements which are adjacent to the current
            LinkedList<Integer> list = adj[current];
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext())
            {
                int item = iterator.next();
                if(!visited[item]) {
                    nodesToVisit.offer(item);
                }


            }

        }
    }

}
public class GraphTraversalAdjacencyList {
    public static void main(String[] args) {
        Graph_Adj graph = new Graph_Adj(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);

        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        graph.DFS(1);
        graph.BFS(1);
    }
}

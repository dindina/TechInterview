package graphs;

import java.util.*;

/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        return 1;

    }

    public List<Integer> path(int flights[][], int src, int dest)
    {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i <flights.length-1;i++)
        {
            graph.add(new ArrayList<>()); // init the graph
        }
        //System.out.println("new graph "  + graph);

        // set the adjacency
        for(int [] edge : flights)
        {
            graph.get(edge[0]).add(edge[1]);
        }

        System.out.println("edges " + graph);

        // start traversing using BFS
        Queue<List<Integer>> queue = new LinkedList<>();

        boolean visited[] = new boolean[graph.size()];
        //a collection to hold the path through which a node has been reached
        //the node it self is the last element in that collection
        List<Integer> pathToNode = new ArrayList<>();
        pathToNode.add(src);
        queue.offer(pathToNode);

        while(!queue.isEmpty())
        {
            pathToNode = queue.poll();
            //get node (last element) from queue
            Integer node = pathToNode.get(pathToNode.size()-1);
            System.out.println("last node " + node);
            if(node == dest) {
                System.out.println("pathToNode " + pathToNode);
                return pathToNode;

            }
            // find their neighbours
            List<Integer> neighbours =  graph.get(node);
            for(Integer neighbour :neighbours) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    //create a new collection representing the path to nextNode
                    List<Integer> pathToNextNode = new ArrayList<>(pathToNode);
                    System.out.println("pathToNextNode before " + pathToNextNode);
                    pathToNextNode.add(neighbour);
                    System.out.println("pathToNextNode after " + pathToNextNode);
                    queue.add(pathToNextNode); //add all paths to the queue
                }
            }

        }

        return null;


    }


    public static void main(String[] args) {
        int [][] flights = new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {3,1},
                {2,3},
                {3,0}

        };

        System.out.println(new CheapestFlightsWithinKStops().path(flights,1,0));

    }



}

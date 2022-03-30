package graphs.bfs;



import java.util.*;

public class ShortestPathFromSourceToDestination {
    public static void main(String[] args) {
        int[][] edges = new int[][]
                {
                        {1,6}, {2, 3}, {4}, {5}, {5}, {6}, {}
                };

        System.out.println(new ShortestPathFromSourceToDestination().shortestPath(7,edges,0,6));

    }

    private List<Integer> shortestPath(int max, int[][] edges, int source, int destination) {

        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[max];
        Arrays.fill(prev,-1);
        queue.offer(source);
        boolean visited[] = new boolean[max];
        visited[source]=true;
        while (!queue.isEmpty()) {
                int curr = queue.poll();
                int[] neighbours = edges[curr];
                for (int ne : neighbours) {
                    if (!visited[ne]) {
                        queue.offer(ne);
                        visited[ne]=true;
                        prev[ne]=curr;
                    }
                }
            }
        return reconstructPath(prev,source,destination);

    }

    private List<Integer> reconstructPath(int[] prev, int source, int destination) {

        for(int k : prev)
        {
            System.out.print(k + ",");
        }
        System.out.println();
        List<Integer> route = new ArrayList<>();

        int pos = destination;
        while(pos !=-1)
        {
            route.add(pos);
            pos = prev[pos];
        }

        Collections.reverse(route);
        return route;
    }
}

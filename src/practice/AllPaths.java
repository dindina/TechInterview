package practice;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    public static void main(String[] args) {


        int[][] grid = new int[][]
                {
                        {1, 2, 6},
                        {3},
                        {5},
                        {4},
                        {},
                        {4},
                        {4}

                };
        System.out.println(new AllPaths().findAllPaths(grid));

    }

    private List<List<Integer>> findAllPaths(int[][] grid) {
        List<List<Integer>> allpaths = new ArrayList<>();
        int source=0;
        int destination=4;
        int total = grid.length;
        boolean[] visited = new boolean[total];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(source);
        backt(source,destination,grid,visited,allpaths,path);
        return allpaths;
    }

    private void backt(int source, int destination, int[][] grid,
                       boolean[] visited, List<List<Integer>> allpaths, ArrayList<Integer> objects) {
        if(source == destination)
        {
            allpaths.add(new ArrayList<>(objects));
        }
        // find all neighbours of the source
        int[] neighbours = grid[source];
        for(int i : neighbours)
        {
            //if(!visited[i])
            {
                ///visited[i]=true;
                objects.add(i);
                backt(i,destination,grid,visited,allpaths,objects);
                objects.remove(objects.size()-1);
            }
        }

    }
}

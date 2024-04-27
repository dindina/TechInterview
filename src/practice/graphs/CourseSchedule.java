package practice.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 */
public class CourseSchedule {
    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(new CourseSchedule().canFinish(2,prerequisites));
     }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] array : prerequisites)
        {
            if(map.containsKey(array[1]))
                map.get(array[1]).add(array[0]);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(array[0]);
                map.put(array[1],list);
            }
        }
        System.out.println(map);
        int[] visited = new int[numCourses];
        for(int i=0 ;i <numCourses;i++)
        {
            if(!canfinish_dfs(i,map,visited))
                return false;
        }
        return true;
    }

    private boolean canfinish_dfs(int i,HashMap<Integer, List<Integer>> map, int[] visited) {
        if(visited[i] ==-1) return false;
        if(visited[i] ==1 ) return true;


        if(map.containsKey(i)) {
            List<Integer> courses = map.get(i);
            for (int course : courses) {
                visited[course] = -1;
                if (!canfinish_dfs(course, map, visited)) return false;
                visited[course] = 1;
            }
        }

        return true;
    }
}

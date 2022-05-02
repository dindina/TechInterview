package graphs.bfs;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

 */
public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0}};
        //System.out.println(findOrder(2,prerequisites));
        //prerequisites = new int[][]{{1,0},{0,1}};
        //System.out.println(findOrder(2,prerequisites));
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(4,prerequisites));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] ingrid = new int[numCourses];
        int []visited = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int[] array : prerequisites)
        {
            if(map.containsKey(array[1]))
            {
                map.get(array[1]).add(array[0]);
            }
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(array[0]);
                map.put(array[1],list);
            }
            ingrid[array[0]] += 1;
        }
        // find all with ingrid 0 and put to q

        for(int i=0 ; i<numCourses; i++)
        {
            if(ingrid[i]==0)
            {
                queue.offer(i);
            }
        }

        List<Integer> path = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0 ; i <size; i++)
            {
                int val = queue.poll();
                if(ingrid[val] ==0) path.add(val);
                if(map.containsKey(val))
                {
                    List<Integer> courses = map.get(val);
                    for(int course : courses)
                    {
                        ingrid[course]--;
                        if(ingrid[course]==0)
                        {
                            queue.offer(course);
                        }


                    }
                }
            }
        }
        System.out.println("path  " + path);


        return result;
    }
}

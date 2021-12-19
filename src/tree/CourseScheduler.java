package tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class CourseScheduler {

    //https://leetcode.com/problems/course-schedule/
    /*
    Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
     */

    // we are going to use  the toplogical sort alogorithm
    public static boolean canFinish(int numCourses, int[][] prerequisites) {


        LinkedList<Integer>[]  adjList = new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adjList[i] = new LinkedList<>();
        }
        // need to build indegree list and adj list
        int [] indegree = new int[numCourses];
        for(int i =0 ; i <prerequisites.length; i++ )
        {
            int[] pair = prerequisites[i];
            indegree[pair[0]]++;
            adjList[pair[1]].add(pair[0]);
        }
        System.out.println("indegree list");
        for(int i=0; i<indegree.length;i++)
            System.out.println(i + " "  + indegree[i]);

        System.out.println("adjlist list");
        for(int i=0; i<adjList.length;i++)
            System.out.println(i + " "  + adjList[i]);

        // now we have both the adj list and indegree list
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< indegree.length;i++)
        {
            if(indegree[i] == 0)
                stack.push(indegree[i]);
        }
        // check cycle logic
        int count = 0;
        while(!stack.isEmpty())
        {
            int current = stack.pop();
            count++;
            // get the adj of the current
            LinkedList<Integer> adj = adjList[current];
            Iterator<Integer> iterator = adj.iterator();
            while(iterator.hasNext())
            {
                int next = iterator.next();
                indegree[next]--;
                if(indegree[next] == 0)
                {
                    stack.push(next);
                }
            }

        }


        return count==numCourses;

    }

    public static void main(String[] args) {

        int preReq [][] = new int[][]
                {
                        {1,0},
                        {2,1},
                        {2,5},
                        {0,3},
                        {4,3},
                        {3,5},
                        {4,5}
                };
        int courseCount = 6;
        System.out.println(canFinish(courseCount,preReq));

    }
}

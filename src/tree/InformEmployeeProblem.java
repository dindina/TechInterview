package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class InformEmployeeProblem {
    //https://leetcode.com/problems/time-needed-to-inform-all-employees/
    /*
    A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
     */


    public static  int numOfMinutes(int total, int headID, int[] manager, int[] informTime) {

        LinkedList<Integer> [] adjacencyList = new LinkedList[total];
        for(int i=0; i< total; i++)
        {
            adjacencyList[i] = new LinkedList<>();
        }
        // set the head
        //int[] manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        for(int i= 0; i < manager.length ; i++)
        {
            if(manager[i]!=-1)
                adjacencyList[manager[i]].add(i);
        }
        System.out.println("adjacencyList list");
        for(int i=0; i<adjacencyList.length;i++)
            System.out.println(i + " "  + adjacencyList[i]);

        // peform DFS
        // this function works for any emp id
        // we start with head id
        return getTime(headID,adjacencyList,informTime);

    }

    public static int getTime(int empId,LinkedList<Integer> [] adjacencyList,int []informTime)
    {
        // employee with no sub
        if(adjacencyList[empId].isEmpty())
            return 0;
         int max = 0;

         LinkedList<Integer> subList = adjacencyList[empId];
         Iterator<Integer> iterator = subList.iterator();
         while(iterator.hasNext())
         {
             int currentEmp = iterator.next();
             max  = Math.max(max, getTime(currentEmp,adjacencyList,informTime));
         }

        return max + informTime[empId];

    }

    public static void main(String[] args) {
        int totalEmployee = 15;
        //int totalEmployee = 8;
        int headId = 0;
        //int headId = 4;
        int[] manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        //int[] manager = new int[]{2,2,4,6,-1,4,4,5};
        int[] informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        //int[] informTime = new int[]{0,0,4,0,7,3,6,0};
        System.out.println(numOfMinutes(totalEmployee,headId,manager,informTime));
    }
}

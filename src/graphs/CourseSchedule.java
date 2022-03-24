package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(canFinish(2,prerequisites));
        prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(canFinish(2,prerequisites));
        prerequisites = new int[][]{{0,1},{2,3},{3,4},{4,5}};
        System.out.println(canFinish(6,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, i))
                return false;
        }

        return true;

    }

    private static boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i){
        if(visit[i]==-1)
            return false;
        if(visit[i]==1)
            return true;

        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j))
                    return false;
            }
        }

        visit[i]=1;
        return true;
    }

}

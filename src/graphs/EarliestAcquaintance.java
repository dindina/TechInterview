package graphs;

import java.util.Arrays;
import java.util.Comparator;


/*
https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
There are n people in a social group labeled from 0 to n - 1. You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.

Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.



Example 1:

Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
Output: 20190301
Explanation:
The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friends anything happens.
The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.
Example 2:

Input: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
Output: 3
 */
public class EarliestAcquaintance {
    class DisjointRank
    {
        int max;
        int []root;
        int[] rank;

        DisjointRank (int max)
        {
                this.max = max;
                root = new int[max];
                rank = new int[max];
                for(int i=0 ; i < max; i++)
                {
                    root[i]=i;
                    rank[1]=1;
                }
        }

        int find(int x)
        {
            if(x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        boolean union(int x, int y)
        {
            int rootX= find(x);
            int rootY=find(y);
            if(rootX!=rootY)
            {
                if(rank[rootX] > rank[rootY])
                {
                    rank[rootY] = rootX;
                }
                else if(rank[rootX] < rank[rootY])
                {
                    rank[rootX] = rootY;
                }
                else // chose X as the rank and increase its rank
                {
                    rank[rootY] = rootX;
                    rank[rootX]+=1;
                }
            }
            return false;
        }

    }


    public int earliestAcq(int[][] logs, int n) {

        // sort the logs based on timestamp
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override public int compare(final int[] o1, final int[] o2) {

                return o1[0]-o2[0];
            }
        });
        int groupCount=n;

        DisjointRank dj = new DisjointRank(n);
        for(int i=0; i< logs.length; i++)
        {
            int timestamp= logs[i][0];
            int friend1 = logs[i][1];
            int friend2 = logs[i][2];

            if(dj.union(friend1,friend2))
            {
                groupCount-=1;
            }
            if(groupCount==1)
                return timestamp;
        }

        return -1;
    }

}

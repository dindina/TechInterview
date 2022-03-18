package graphs;

import java.util.Arrays;


/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c,
then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


 */
public class NumberOfProvinces {

    class DisjointSet {
        int [] root;
        int maxcount;
        DisjointSet(int count) {
            maxcount=count;
            root = new int [count];
            for(int i=0 ; i< count; i++)
                root[i]=i;// intial , set root to itself
            printroot();
        }
        // quick find .
        public int find(int x) {
            return root[x];
        }

        public void union(int x,int y) {
            int rootX= find(x);
            int rootY= find(y);

            if(rootX!=rootY) {
                for (int i = 0; i < root.length; i++) {
                    if(root[i] == rootY)
                        root[i] = rootX;
                }
            }

        }

        public void printroot() {
            for (int i = 0; i < root.length; i++) {
                System.out.print(root[i]  + ",");
            }
            System.out.println();

        }
    }


    public  long findCircleNum(int[][] isConnected) {

        DisjointSet dj = new DisjointSet(isConnected.length);
        for(int i=0;i<isConnected.length;i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j]==1 )
                    dj.union(i,j);
                dj.printroot();
            }
        }
        System.out.println("final");
        dj.printroot();
        return Arrays.stream(dj.root).distinct().count();
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        //System.out.println(isConnected.length);
        //System.out.println(isConnected[0].length);
        for(int i=0;i<isConnected.length;i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                System.out.print(isConnected[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("he");
        long no = new NumberOfProvinces().findCircleNum(isConnected);
        System.out.println("final " + no);

    }

}

package practice;

import java.util.Arrays;

public class DisjointSet {
    int capacity=0;
    int [] root;
    DisjointSet(int capacity)
    {
        root = new int[capacity];
        this.capacity=capacity;
        for(int i=0; i <root.length ; i++)
            root[i]=i;
    }

    public int find(int x)
    {
        if(x > capacity) return -1;
        return root[x];
    }

    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
            for(int i=0; i <root.length ; i++)
            {
                if(root[i]  == rootY)
                {
                    root[i]=rootX;
                }
            }
        }

    }

    public boolean isConnected(int x , int y) {
        return find(x) == find(y);
    }

    public void printroot() {
        for (int i = 0; i < root.length; i++) {
            System.out.print(root[i]  + ",");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(6);
        disjointSet.union(0,1);
        disjointSet.union(0,2);
        disjointSet.union(0,3);

        disjointSet.union(4,5);

        System.out.println(disjointSet.isConnected(0,1));
        System.out.println(disjointSet.isConnected(1,2));
        System.out.println(disjointSet.isConnected(1,3));
        System.out.println(disjointSet.isConnected(4,5));
        System.out.println(disjointSet.isConnected(1,5));
        System.out.println(disjointSet.isConnected(1,4));
        disjointSet.printroot();
        System.out.println("count " + Arrays.stream(disjointSet.root).distinct().count());

    }

}

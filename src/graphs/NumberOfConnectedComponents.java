package graphs;

import java.util.Arrays;


public class NumberOfConnectedComponents {

    class DisjointSet
    {
        int max;
        int []root;

        DisjointSet(int n)
        {
            max=n;
            root= new int [n];
            for(int i=0 ; i<n ;i++)
            {
                root[i]=i;
            }
            printRoot();

        }

        public int find(int x)
        {
            if(x > max)
                return -1;
            return root[x];
        }
        public void union(int x,int y)
        {
            int rootX=find(x);
            int rootY=find(y);

            if(rootX!=rootY)
            {
                for(int i=0; i <max; i++ )
                {
                    if(root[i] == rootY)
                    {
                        root[i] = rootX;
                    }
                }
            }

        }

        public void printRoot()
        {
            System.out.println("-----------");
            for(int i=0 ; i <root.length ; i++)
                System.out.print(root[i] +",");
            System.out.println("-----------");
        }
    }


    public int countComponents(int n, int[][] edges) {

        DisjointSet dj = new DisjointSet(n);
        for(int i=0 ; i <edges.length;i++) {
                dj.union(edges[i][0],edges[i][1]);
        }
        dj.printRoot();
        return (int)Arrays.stream(dj.root).distinct().count();
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents n = new NumberOfConnectedComponents();
        int [][] edges = new int [][]{
                {0,1},{1,2},{2,3},{3,4}
        };
        System.out.println("total con" + n.countComponents(5,edges));

    }

}

package graphs;

public class DisjointSetUnionByRank {
    int [] root;
    int [] rank;
    int verticesCount;
    DisjointSetUnionByRank(int verticesCount)
    {
        this.verticesCount = verticesCount;
        root = new int[verticesCount];
        rank = new int[verticesCount];
        for(int i=0 ; i< verticesCount ; i++)
        {
            root[i]=i;
            rank[i]=1;
        }
    }
    public void printRoots()
    {
        for(int i=0 ; i< verticesCount ; i++)
        {
            System.out.print(root[i] + " , ");
        }
        System.out.println();
    }
    int find(int x)
    {
        if(x==root[x])
            return x;
        return root[x] = find(root[x]);// path compression

    }

    // x is the root and y is the vertex to be connected
    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if (rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else // equal rank - choosing x a the root
            {
                root[rootY] = rootX;
                rank[x]+=1;
            }
        }
    }

    public boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }


    public static void main(String[] args)
    {
        DisjointSetUnionByRank dj = new DisjointSetUnionByRank(7);
        dj.printRoots();
        dj.union(0,1);
        dj.union(0,2);
        dj.union(1,3);
        dj.union(4,5);
        dj.union(5,6);
        dj.union(0,4);
        dj.printRoots();
        System.out.println(dj.connected(6,1));
        dj.union(0,4);
        dj.printRoots();
        System.out.println(dj.connected(6,1));

    }

}

package graphs;

public class QuickUnionDisjointSet {
    int [] root;
    int verticesCount;
    QuickUnionDisjointSet(int verticesCount)
    {
        this.verticesCount = verticesCount;
        root = new int[verticesCount];
        for(int i=0 ; i< verticesCount ; i++)
        {
            root[i]=i;
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
        while(x!=root[x])
            x=root[x];
        return x;



    }

    // x is the root and y is the vertex to be connected
    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
             root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }


    public static void main(String[] args)
    {
        QuickUnionDisjointSet dj = new QuickUnionDisjointSet(10);
        dj.printRoots();
        dj.union(0,1);
        dj.union(0,2);
        dj.union(1,3);
        dj.union(4,5);
        dj.union(5,6);
        //dj.union(0,4);
        dj.printRoots();
        System.out.println(dj.connected(6,1));

    }

}

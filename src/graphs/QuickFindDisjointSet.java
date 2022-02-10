package graphs;

public class QuickFindDisjointSet {
    int [] root;
    int verticesCount;
    QuickFindDisjointSet(int verticesCount)
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
    int find(int vertex)
    {
        return root[vertex];
    }

    // x is the root and y is the vertex to be connected
    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
            for(int i=0;i<root.length;i++)
            {
                if(root[i] == rootY)// change th root if is the same as Y
                    root[i] = rootX;

            }
        }
    }

    public boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }


    public static void main(String[] args)
    {
        QuickFindDisjointSet dj = new QuickFindDisjointSet(7);
        dj.printRoots();
        dj.union(0,1);
        dj.union(0,2);
        dj.union(1,3);
        dj.union(1,4);
        dj.union(2,5);
        dj.union(2,6);
        dj.printRoots();
        System.out.println(dj.connected(6,1));

    }

}

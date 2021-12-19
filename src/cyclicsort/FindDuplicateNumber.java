package cyclicsort;

public class FindDuplicateNumber {
    public static void main(String[] args) {

            System.out.println(findNumber(new int[] { 1, 2,4, 3, 5 }));
            System.out.println(findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
            System.out.println(findNumber(new int[] { 2, 4, 1, 4, 4 }));


    }

    private static int findNumber(final int[] array) {

        // do cyclic sort for array 1 to N

        int i = 0;
        while(i < array.length)
        {
            int actualValueNeeded = array[i]-1;

            if(array[i] != i+1)
            {
                swap(array,i,array[i+1]);
                /*System.out.println("after swap");
                for(i=0; i< array.length ;  i++)
                {
                    System.out.print(array[i] +" ");
                }
                System.out.println();*/
            }
            else
                i++;
        }

        System.out.println("sorted");
        for(i=0; i< array.length ;  i++)
        {
            System.out.print(array[i] +" ");
        }
        System.out.println();

        for(i=0; i< array.length ;  i++)
        {
            if(array[i]!=i+1)
                return array[i];
        }

        return -1;



    }

    private static void swap(final int[] array, final int i, final int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1]= temp;
    }

}

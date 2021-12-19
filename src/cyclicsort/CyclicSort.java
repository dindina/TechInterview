package cyclicsort;


/*
The numbers in the array are distinct but shuffled.And if the size of array i N , it means all numbers from 1 to N are present in the array.
Given such an array sort it in-place in O(n) complexity.
 */
public class CyclicSort {

    public static void main(String[] args) {
        int a[] = new int[] { 1, 3, 4, 6, 5, 2 };
        //int a[] = new int[] { 4,0,3,1 };

        cyclicSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        /*int a1[] = new int[] { 0, 3, 2, 1, 5, 4 };
        cyclicSortZeroToNArray(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }*/



    }

    private static void cyclicSort(int[] array) {

        int i=0;
        while(i< array.length)
        {

            if(array[i] == i+1)
                i++;
            else
            {
                //find the correct index of the current element in sorted array
                int correctIndex =   array[i] -1;
                swap(array,correctIndex,i);
            }
        }
    }

    private static void swap(final int[] array, final int i, final int value) {
        int temp = array[i];
        array[i] = array[value];
        array[value]=temp;
    }


    private static void cyclicSortZeroToNArray(int[] array)
    {
        // [0,3,4,2,1]
        int i=0;
        while(i < array.length)
        {
            if(array[i] != i)
            {
                swap(array,i,array[i]);
            }
            else
                i++;
        }
    }
}

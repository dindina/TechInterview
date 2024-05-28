package arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,4,6,71,8};

        int min = Integer.MAX_VALUE;
        for(int j=2 ; j<arr.length-1;j++) {
            min = Math.min(min, arr[j]);
        }
        //System.out.println(min);

        ArrayUtil.printArray(arr);
        selectionSort(arr);
        System.out.println("final");
        ArrayUtil.printArray(arr);


    }

    public static void selectionSort(int[] arr)
    {
        for(int i=0; i< arr.length-1;i++)
        {

            int min = Integer.MAX_VALUE;
            int swapIndex =0;

            for(int j=i ; j<arr.length;j++)
            {
                System.out.println("arr[j] " + arr[j]);
                if(arr[j]<min) {
                    min = arr[j];
                    swapIndex=j;
                }

            }
            System.out.println("min " + min);
            System.out.println("swapIndex " + swapIndex);
            swap(arr,i,swapIndex);
            ArrayUtil.printArray(arr);
        }
    }

    public static void swap(int[]arr , int i , int j)
    {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}

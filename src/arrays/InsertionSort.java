package arrays;

public class InsertionSort {
    public static void main(String[] args) {

            int[] arr = new int[]{10, 4, 6, 71, 8};

            int min = Integer.MAX_VALUE;
            for (int j = 2; j < arr.length - 1; j++) {
                min = Math.min(min, arr[j]);
            }
            //System.out.println(min);

            ArrayUtil.printArray(arr);
            insertionsort(arr);
            System.out.println("final");
            ArrayUtil.printArray(arr);



    }

        public static void insertionsort ( int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                int j=i;
                while(j>0 && arr[j-1] > arr[j])
                {
                    swap(arr,j,j-1);
                }
            }
        }
        public static void swap ( int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

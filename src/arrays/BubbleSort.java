package arrays;

public class BubbleSort {
    public static void main(String[] args) {

            int[] arr = new int[]{10, 4, 6, 71, 8};

            int min = Integer.MAX_VALUE;
            for (int j = 2; j < arr.length - 1; j++) {
                min = Math.min(min, arr[j]);
            }
            //System.out.println(min);

            ArrayUtil.printArray(arr);
            bubblesort(arr);
            System.out.println("final");
            ArrayUtil.printArray(arr);



    }

        public static void bubblesort ( int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        swap(arr, i, j);
                    }
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

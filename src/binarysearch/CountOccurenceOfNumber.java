package binarysearch;

public class CountOccurenceOfNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2,2};
        System.out.println(count(arr,2));


    }

    public static int count(int[] arr , int target)
    {
        int result=0;

        int low=0;
        int high=arr.length-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            System.out.println("mid "+mid);

            if(arr[mid]==target) {
                result++;

                int newmid = mid;
                while (++newmid<=arr.length-1  && arr[newmid] == target) {
                    System.out.println("newmid" + newmid);
                    result++;
                }

                newmid=mid;
                while (--newmid>=0  && arr[newmid] == target) {
                    System.out.println("one more ading");
                    result++;
                }
                break;
                //System.out.println("result " + result);
            }

            else if(arr[mid]>target){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return result;
    }

}

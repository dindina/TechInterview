package binarysearch;

public class NthRootOfInteger {

    public static void main(String[] args) {
        int num = 27;
        int n = 3;

        //System.out.println(nthroot(64,3));
        //System.out.println(nthroot(-125,3));
        //System.out.println(nthroot(9,2));
        System.out.println(nthroot(4,1));
    }

    public static int nthroot(int num, int n)
    {
        if(num ==0)
            return -1;
        if(num==1)
            return num;
        if(n==1)
            return num;

        int left= 0;
        int right=Math.abs(num)/2;
        //System.out.println(left);
        while(left<=right)
        {

            //System.out.println("left " + left);
            //System.out.println("right " + right);
            int mid = left + (right-left)/2;
            //System.out.println("mid " + mid);
            double val;
            if(n==1) {
                val = mid*mid;
            }
            {
                val = Math.pow(mid, n);
            }
            if(val ==num)
            {
                return mid;
            }
            else if(val > num)
            {
                right=mid-1;
            }
            else {
                left=mid+1;
            }

        }

        return -1;

    }
}

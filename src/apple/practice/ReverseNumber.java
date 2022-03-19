package apple.practice;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(new ReverseNumber().reverse(num));
    }

    private int reverse(int num) {

        long result=0;
        while(num !=0)
        {
            int mod = num %10;
            result = result*10 + mod;
            num = num/10;
        }
        if(result <Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        else
            return (int)result;
    }


}

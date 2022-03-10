package apple.practice;

public class MisingNumber {
    public int missingNumber(int[] nums) {

        int xor=nums.length;
        for(int i=0; i< nums.length;i++)
        {
            xor ^= i ^nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(new MisingNumber().missingNumber(nums));
    }
}


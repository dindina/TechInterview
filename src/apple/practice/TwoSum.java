package apple.practice;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int [] result = new int[2];

        if(nums ==null ||nums.length ==0)
        {
            result[0]=-1;
            result[1]=-1;
            return result;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0 ;i< nums.length;i++) {
            int pair_needed = target - nums[i];

            if (map.containsKey(pair_needed)) {
                int index1 = map.get(pair_needed);
                result[0] = index1;
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        result[0]=-1;
        result[1]=-1;
        return result;

    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,4,6,7,8};
        int [] index = new TwoSum().twoSum(nums,1);
        System.out.println(index[0]);
        System.out.println(index[1]);
    }
}

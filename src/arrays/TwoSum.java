package arrays;

//[1,4,5,7,12,3]
// test cases
// 1. null array
// 2. with valid indexes and sum
// 3. without correct index
// size of array must be > 1

import java.util.HashMap;
import java.util.Map;


public class TwoSum {

    public static void main(String[] args) {

        int[] array = new int[] { 10, 2, 9, 4 ,13};
        int[] result = two_sum_new(array, 13);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] two_sum_new(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pairneeded = target - nums[i];
            if (map.containsKey(pairneeded)) {
                int[] result = new int[2];
                result[0] = map.get(pairneeded);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

}




























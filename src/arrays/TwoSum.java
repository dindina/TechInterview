package arrays;

//[1,4,5,7,12,3]
// test cases
// 1. null array
// 2. with valid indexes and sum
// 3. without correct index
// size of array must be > 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSum {

    public static void bruteforce() {
        int[] array = new int[] { 1, 4, 5 };
        int target = 6;
        int ptr2;
        int ptr1 = 0;
        while (ptr1 < array.length) {
            int number_pair_required = target - array[ptr1];
            ptr2 = ptr1 + 1;
            while (ptr2 < array.length) {
                if (number_pair_required == array[ptr2]) {
                    System.out.println("ptr1 " + ptr1 + " , ptr2 " + ptr2);
                    break;
                } else
                    ptr2++;
            }
            ptr1++;
        }

    }

    public static void main(String[] args) {

        int[] array = new int[] { 10, 2, 9 ,4 };
        int target = 19;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ptr = 0; ptr < array.length; ptr++) {
            int pair_needed = target-array[ptr];
            if(!map.containsKey(array[ptr])) {
                map.put(pair_needed, ptr);
                System.out.println(map);
            }
            else {
                System.out.println("ptr1 " + ptr + " , ptr2 " + map.get(array[ptr]));
                break;
            }
        }
        //twosum();
        twoSum();
        int [] result = two_sum_new(array,13);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] two_sum_new(int [] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int pairneeded = target-nums[i];
            if(map.containsKey(pairneeded))
            {
                int[] result = new int[2];
                result[0] = map.get(pairneeded);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }




    public static void twosum()
    {
        int[] integerList = new int[]{10,20,14,15};
        int target = 34;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i <integerList.length;i++)
        {
            int pair_needed = target - integerList[i];
            // make a hash table with key as the pair_needed and value as the index
            if(!map.containsKey(integerList[i]))
            {
                map.put(pair_needed,i);
            }
            else
            {
                System.out.println("pair is " + integerList[i] + ", " + integerList[map.get(integerList[i])]);
            }

        }
    }

    public static void twoSum()
    {
        int [] array = new int[]{1,4,5,6,7,25};
        int target = 30;
        HashMap<Integer, Integer> map = new HashMap<>();

        // logic create a hashmap with key as the pair needed and the corresponding index of the array
        for(int i=0; i< array.length ; i++)
        {
            int pair_needed = target - array[i];
            if(!map.containsKey(array[i]))
            {
                map.put(pair_needed,i);
                System.out.println(map);
            }
            else
            {
                System.out.println("pair " + array[i] + "," + array[map.get(array[i])]  );
            }

        }
    }























}

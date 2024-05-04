package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * https://www.naukri.com/code360/problems/fruits-and-baskets_985356?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
 * Problem statement
 * There are ‘n’ fruit trees that are planted along a road. The trees are numbered from 0 to n-1. The type of fruit each tree bears is represented by an integer from 1 to 'n'.
 *
 *
 *
 * A Ninja is walking along that road. He has two baskets and wants to put the maximum number of fruits in them. The restriction is that each basket can have only one type of fruit.
 *
 *
 *
 * Ninja can start with any tree and end at any tree, but once he has started, he cannot skip a tree i.e if he picks fruit from the tree ‘i’, then he has to pick fruit from tree ‘i+1’ before going to the tree ‘i+2’. He will pick one fruit from each tree until he cannot, i.e, he will stop when he has to pick a fruit of the third type because only two different fruits can fill both baskets.
 *
 *
 *
 * You are given an array ‘arr’. The ‘i’th integer in this array represents the type of fruit tree ‘i’ bears. Return the maximum number of fruits Ninja can put in both baskets after satisfying all the conditions.
 *
 *
 *
 * For Example:
 *  'arr' = [1, 2, 3]
 *
 *  Here, we have three different types of fruits. We can pick [1, 2] or [2, 3]. We can pick a maximum of two fruits.
 *
 * Hence, we return 2.
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(fruitsBaskets(nums));

    }

    public static int fruitsBaskets(int []nums)
    {
        int left=0;
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int right=0; right < nums.length; right++)
        {

            // check the map or put the count into map
            int fruitType = nums[right];
            map.put(fruitType,map.getOrDefault(map.get(fruitType),0));
            // condition to count the max;
            if(map.size()<=2)
            {
                max = Math.max(max,right-left+1);
            }
            if(map.size()>2)
            {
                // remove items from map
                map.put(fruitType,map.get(fruitType).intValue()-1);
                if(map.get(fruitType).intValue()==0)
                    map.remove(fruitType);
            }

        }
        return max;


    }
}

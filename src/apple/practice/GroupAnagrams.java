package apple.practice;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase
, typically using all the original letters exactly once.

Example
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = new String (array);
            System.out.println(sorted);
            if(map.containsKey(sorted))
            {
                List<String> list = map.get(sorted);
                list.add(str);
            }
            else
            {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(sorted,stringList);
            }
        }
        System.out.println(map);
        for(Map.Entry<String,List<String>> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs  = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}

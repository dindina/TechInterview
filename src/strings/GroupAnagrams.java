package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap <String,List<String>> map = new HashMap<>();
        List<List<String>> returnList = new ArrayList<>();
        // logic create a hash map with key as the sorted string and value as the string from the array
        for(String str : strs)
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            //System.out.println(sortedString);
            if(map.containsKey(sortedString))
            {
                // add to the list of strings
                List<String> existing = map.get(sortedString);
                existing.add(str);
                map.put(sortedString,existing);

            }
            else
            {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(sortedString,newList);
            }


        }
        returnList.addAll(map.values());
        return returnList;
    }

    public static void main(String[] args) {
        String [] array = new String[]{"teat","tate","bobo","oobb"};
        //System.out.println(groupAnagrams(array));
        System.out.println(group1(array));
    }

    public static List<List<String>> group1(String [] array)
    {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str : array)
        {
            char [] chararray  = str.toCharArray();
            Arrays.sort(chararray);
            String sorted = new String(chararray);
            //System.out.println("sorted str" + chararray.toString());
            if(map.containsKey(sorted))
            {
                System.out.println("isnde");
                ArrayList<String> list = map.get(sorted);
                list.add(str);
                map.put(sorted,list);
            }
            else
            {
                System.out.println("outso");
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }

        }
        result.addAll(map.values());
        return result;
    }


}

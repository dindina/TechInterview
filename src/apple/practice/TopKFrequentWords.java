package apple.practice;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for( String  str : words)
        {
            if(map.containsKey(str))
            {
                map.put(str,map.get(str)+1);
            }
            else
            {
                map.put(str,1);
            }
        }
        System.out.println(map);

        PriorityQueue<String> pq = new PriorityQueue((str1,str2)->map.get(str1)-map.get(str2));
        for(int i=0; i< words.length; i++)
        {
            if(!pq.contains(words[i])) pq.offer(words[i]);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println("pq "  + pq);
        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"d","ed","ss","ss","dd"};
        System.out.println(new TopKFrequentWords().topKFrequent(str,2));
    }
}

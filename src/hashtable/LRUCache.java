package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUCache {

    LinkedHashMap<Integer,Integer> cacheMap;

    int capacity=0;

    public LRUCache(int capacity) {

        cacheMap = new LinkedHashMap<>();
        this.capacity=capacity;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key))
        {
            int cacheValue  = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key,cacheValue);//put it to the front
            return cacheValue;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key))
            cacheMap.remove(key);
        if(cacheMap.size() >= capacity)
        {
            cacheMap.remove(cacheMap.keySet().iterator().next());
        }
        cacheMap.put(key,value);

    }

    public static void main(String[] args) {
        int capacity = 6;
        LRUCache cache = new LRUCache(capacity);

        Map<Integer, String> cacheMap  = new LinkedHashMap<>(capacity);
        cacheMap.put(1,"a");
        cacheMap.put(2,"b");
        cacheMap.put(3,"c");
        System.out.println(cacheMap);
        cacheMap.remove(2);

        cacheMap.put(2,"b1");
        System.out.println(cacheMap);


    }

}

package hashtable;

import java.util.LinkedList;

public class HASHMap {

    public static void main(String[] args) {
        HASHMap map = new HASHMap();
        map.put(1,100);
        map.put(2,100);
        map.put(3,200);
        map.put(1,101);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        map.put(4,101);
        map.remove(1);
        map.remove(111);
        System.out.println(map.get(4));
        System.out.println(map.get(1));
    }

    int SIZE = 769;
    LinkedList<Entry>[] map = null;

    class Entry
    {
        int key;
        int val;
        public Entry(int i, int j)
        {
            key=i;
            val =j;
        }
    }

    public HASHMap()
    {
        map = new LinkedList[SIZE];

    }
    public int finBucket(int key)
    {
        return key %SIZE;
    }
    public void put(int key , int val)
    {
        int bucket = finBucket(key);
        LinkedList<Entry> entries = map[bucket];
        if(entries ==null)
        {
            map[bucket] = new LinkedList<>();
        }
        else
        {
            // iterate the entries
            for(Entry existing:entries)
            {
                if(existing.key == key)
                {
                    existing.val = val;
                    return;
                }
            }
        }
        map[bucket].add(new Entry(key,val));

    }

    public Object get(int key)
    {
        int bucket = finBucket(key);
        LinkedList<Entry> entries = map[bucket];
        if(entries == null)
            return -1;
        else
        {
            for(Entry existing:entries)
            {
                if(existing.key == key)
                {
                     return existing.val;
                }
            }
        }
        return -1;
    }
    public void remove(int key)
    {
        int bucket = finBucket(key);
        LinkedList<Entry> entries = map[bucket];
        if(entries == null)
            return;
        else
        {
            for(Entry existing:entries)
            {
                if(existing.key == key)
                {
                    entries.remove(existing);
                    return;
                }
            }
        }
        return ;
    }

}

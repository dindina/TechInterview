package hashtable;

import java.util.HashMap;

public class GetOrDefault {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"dinesh");
        System.out.println(map.getOrDefault(11,"default"));

    }
}

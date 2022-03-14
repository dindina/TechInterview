package practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "XL";
        int i = convert(roman);
        System.out.println(i);
    }

    public static int convert(String roman)
    {
        Map<Character,Integer>map  = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int current;
        int previous =0;
        int result=0;
        for(int i=roman.length()-1; i>=0 ; i--)
        {
            current = map.get(roman.charAt(i));
            if(current >= previous) {
                result+=current;
            }
            else
            {
                result-=current;
            }
            previous = current;
        }

    return result;

    }

}

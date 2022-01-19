package strings;

public class RomanToNumber {
    public int romanToNumber(String roman)
    {
        int []  charMap = new int[256];
        // map all roman to int
        charMap['I'] = 1;
        charMap['V'] = 5;
        charMap['X'] = 10;
        charMap['L'] = 50;
        charMap['C'] = 100;
        charMap['D'] = 500;
        charMap['M'] = 1000;

        int result=0;
        int previous =1;
        for(int i= roman.length()-1; i>=0 ; i--)
        {
            int current = charMap[roman.charAt(i)];
            if(current < previous)
            {
                result -= current;
            }
            else
            {
                previous=current;
                result += current;
            }

        }
        return result;

    }
    public static void main(String[] args) {

        String roman = "XL";
        System.out.println(new RomanToNumber().romanToNumber(roman));

    }
}

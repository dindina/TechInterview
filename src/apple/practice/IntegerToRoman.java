package apple.practice;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println(new IntegerToRoman().convert(num));

    }

    private String convert(int num) {
        String result="";
        String[] symbols = new String []{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int [] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        // iterate all the values and keep using it if neede
        for(int i=0; i< values.length; i++ )
        {
            while(num >= values[i])
            {
                num = num - values[i];
                result+=symbols[i];
            }
        }
        return result;
    }
}

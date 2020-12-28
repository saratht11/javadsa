package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegers {
    private final Map<Character, Integer> map;

    {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToIntegers toIntegers = new RomanToIntegers();
        System.out.println(toIntegers.getIntegerFromRoman("LIX"));
    }

    public int getIntegerFromRoman(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i > 0 && map.get(input.charAt(i)) > map.get(input.charAt(i - 1))) {
                result += map.get(input.charAt(i)) - 2 * map.get(input.charAt(i - 1));
            } else {
                result += map.get(input.charAt(i));
            }
        }
        return result;
    }

}

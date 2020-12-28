package strings;

public class IntegersToRoman {
    private final String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] thousands = {"", "M", "MM", "MMM"};

    public static void main(String[] args) {
        IntegersToRoman toRoman = new IntegersToRoman();
        System.out.println(toRoman.getRomanFromInt(3910));
    }

    public String getRomanFromInt(int input) {
        return thousands[input / 1000] +
                hundreds[(input % 1000) / 100] +
                tens[(input % 100) / 10] +
                units[input % 10];
    }
}

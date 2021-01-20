package hackerrank.interviewpreparationkit.warmup;

public class RepeatedStrings {
    static long repeatedString(String s, long n) {
        String finals = s;
        for (long i = 0; i < n; i++) {
            if (finals.length() + s.length() < n) {
                finals = finals + s;
            } else {
                long ok = n - (long) finals.length();
                finals = finals + s.substring(0, (int) ok);
            }
        }
        long initial = 0;
        for (char c : finals.toCharArray()) {
            if ('a' == c) {
                initial++;
            }
        }
        return initial;
    }

    static long repeatedString2(String s, long n) {
        String finals = "";
        for (long i = 0; i < n * s.length(); i++) {
            finals += s;
        }
        long initial = 0;
        for (char c : finals.toCharArray()) {
            if ('a' == c) {
                initial++;
            }
        }
        return initial;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString3("aba", 10));
    }

    static long repeatedString3(String s, long n) {
        long count = getCount(s);
        long ok = n / s.length();
        count = count * ok;
        count += getCount(s.substring(0, (int) (n % s.length())));
        return count;
    }

    private static long getCount(String s) {
        long initial = 0;
        for (char c : s.toCharArray()) {
            if ('a' == c) {
                initial++;
            }
        }
        return initial;
    }
}

package strings;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        //System.out.println(palindrome.isPalindrome("mmq"));
        //System.out.println(palindrome.isPalindrome("mam", 0, 2));
        //System.out.println(palindrome.longestPalindromeBF("ac"));
        System.out.println(palindrome.longestPalindromeEAC("abacdgfdcaba"));
    }

    /**
     * Brute force approach
     * t.c  O(n^3)
     */
    public String longestPalindromeBF(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String currentSS = s.substring(i, j);
                if (isPalindrome(currentSS)) {
                    if (currentSS.length() > output.length()) {
                        output = currentSS;
                    }
                }
            }
        }
        return output;
    }

    public boolean isPalindrome(String input) {
        int j = input.length() - 1;
        int i = 0;
        while (i < j) {
            if (input.charAt(i++) != input.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String input, int s, int e) {
        if (s == e) {
            return true;
        }
        if (input.charAt(s) != input.charAt(e)) {
            return false;
        }
        if (s < e + 1) {
            return isPalindrome(input, s + 1, e - 1);
        }
        return true;
    }

    /**
     * t.c  O(n^2)
     */
    public String longestPalindromeEAC(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCorner(s, i, i);
            int len2 = expandAroundCorner(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCorner(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int windowSize = n; windowSize > 0; windowSize--) {
            for (int start = 0; start <= n - windowSize; start++) {
                int end = start + windowSize - 1;
                if (isPalindrome(s, start, end)) {
                    return s.substring(start, end + 1);
                }
            }
        }
        return "";
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
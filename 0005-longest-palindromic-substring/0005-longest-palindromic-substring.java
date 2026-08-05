class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String longestPal = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                if (isPalindrome(s, i, j)) {
                    int currentLength = j - i + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        longestPal = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPal;
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
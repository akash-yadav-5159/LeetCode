class Solution {
    Integer[][] memo; 
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Integer[n][n]; 
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    private boolean checkPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j] == 1;
        }
        boolean isPalin = false;
        if (s.charAt(i) == s.charAt(j)) {
            isPalin = checkPalindrome(s, i + 1, j - 1);
        }
        memo[i][j] = isPalin ? 1 : 2;
        
        return isPalin;
    }
}
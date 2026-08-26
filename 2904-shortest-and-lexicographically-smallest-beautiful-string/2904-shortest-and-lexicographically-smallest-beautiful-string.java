class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int onesCount = 0;
        String result = "";
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                onesCount++;
            }
            while (onesCount == k) {
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }
                int currentLen = right - left + 1;
                String sub = s.substring(left, right + 1);
                if (currentLen < minLen) {
                    minLen = currentLen;
                    result = sub;
                }
                else if (currentLen == minLen) {
                    if (sub.compareTo(result) < 0) {
                        result = sub;
                    }
                }
                if (s.charAt(left) == '1') {
                    onesCount--;
                }
                left++;
            }
        }
        return result;
    }
}
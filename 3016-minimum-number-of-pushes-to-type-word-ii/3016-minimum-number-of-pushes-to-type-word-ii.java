class Solution {
    public int minimumPushes(String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        Arrays.sort(map);
        int count = 0;
        int j = 0;   
        for (int i = 25; i >= 0; i--) {
            if (map[i] == 0) break;
            count += ((j >> 3) + 1) * map[i];
            j++;
        }
        return count;
    }
}
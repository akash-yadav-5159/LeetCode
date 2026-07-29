class Solution {
    private static final long CAP = 1_000_000L;

    public String smallestPalindrome(String s, int k) {
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] half = new int[26];
        int y = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = count[i] / 2;
            if (count[i] % 2 == 1) y = i;
        }

        int halfLen = s.length() / 2;

        // check total distinct permutations first
        long total = countPermutations(half.clone(), halfLen);
        if (total < k) return "";

        StringBuilder str = new StringBuilder();
        int remainingLen = halfLen;
        long kk = k;

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long cnt = countPermutations(half.clone(), remainingLen - 1);
                if (cnt >= kk) {
                    str.append((char) (c + 'a'));
                    remainingLen--;
                    break;
                } else {
                    kk -= cnt;
                    half[c]++;
                }
            }
        }

        StringBuilder str2 = new StringBuilder(str);
        if (s.length() % 2 == 1) {
            str.append((char) (y + 'a'));
        }
        str = str.append(str2.reverse());
        return str.toString();
    }

    // Computes min(actual multinomial count, CAP+1) for arranging cnt[] into 'rem' slots
    private long countPermutations(int[] cnt, int rem) {
        long res = 1;
        int remaining = rem;
        for (int c = 0; c < 26; c++) {
            int ci = cnt[c];
            if (ci == 0) continue;
            int k = Math.min(ci, remaining - ci);
            for (int i = 1; i <= k; i++) {
                res = res * (remaining - k + i) / i;
                if (res > CAP) return CAP + 1;
            }
            remaining -= ci;
        }
        return res;
    }
}
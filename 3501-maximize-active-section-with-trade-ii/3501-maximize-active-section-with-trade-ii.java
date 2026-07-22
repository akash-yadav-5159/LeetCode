import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();

        // ---- Build runs ----
        List<Integer> startL = new ArrayList<>(), endL = new ArrayList<>(), lenL = new ArrayList<>();
        List<Character> typeL = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            startL.add(i); endL.add(j - 1); lenL.add(j - i); typeL.add(s.charAt(i));
            i = j;
        }
        int K = startL.size();
        int[] runStart = new int[K + 1], runEnd = new int[K + 1], runLen = new int[K + 1];
        char[] runType = new char[K + 1];
        for (int idx = 1; idx <= K; idx++) {
            runStart[idx] = startL.get(idx - 1);
            runEnd[idx]   = endL.get(idx - 1);
            runLen[idx]   = lenL.get(idx - 1);
            runType[idx]  = typeL.get(idx - 1);
        }

        int[] runId = new int[n];
        for (int idx = 1; idx <= K; idx++)
            for (int p = runStart[idx]; p <= runEnd[idx]; p++) runId[p] = idx;

        long totalOnes = 0;
        for (int idx = 1; idx <= K; idx++) if (runType[idx] == '1') totalOnes += runLen[idx];

        // ---- V[j] for interior 1-runs ----
        final int NEG = Integer.MIN_VALUE / 2;
        int[] V = new int[K + 1];
        Arrays.fill(V, NEG);
        for (int j = 2; j <= K - 1; j++)
            if (runType[j] == '1') V[j] = runLen[j - 1] + runLen[j + 1];

        // ---- Sparse table for range max on V ----
        int[] log2 = new int[K + 2];
        for (int x = 2; x <= K + 1; x++) log2[x] = log2[x / 2] + 1;
        int maxLog = log2[Math.max(K, 1)] + 1;
        int[][] st = new int[maxLog][K + 1];
        for (int j = 1; j <= K; j++) st[0][j] = V[j];
        for (int k = 1; k < maxLog; k++) {
            int half = 1 << (k - 1);
            for (int j = 1; j + (1 << k) - 1 <= K; j++)
                st[k][j] = Math.max(st[k - 1][j], st[k - 1][j + half]);
        }

        int m = queries.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(m, 0));

        for (int qi = 0; qi < m; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            int a = runId[l], b = runId[r];
            long gain = 0;

            if (a != b) {
                int clipLenA = runEnd[a] - l + 1;
                int clipLenB = r - runStart[b] + 1;

                if (b == a + 1) {
                    gain = 0;
                } else if (b == a + 2) {
                    int j = a + 1;
                    gain = (runType[j] == '1') ? (long) clipLenA + clipLenB : 0;
                } else {
                    long best = 0;
                    int j1 = a + 1;
                    if (runType[j1] == '1') {
                        int right = (j1 + 1 == b) ? clipLenB : runLen[j1 + 1];
                        best = Math.max(best, (long) clipLenA + right);
                    }
                    int j2 = b - 1;
                    if (runType[j2] == '1') {
                        int left = (j2 - 1 == a) ? clipLenA : runLen[j2 - 1];
                        best = Math.max(best, (long) left + clipLenB);
                    }
                    if (b - 2 >= a + 2) {
                        int lo = a + 2, hi = b - 2;
                        int k = log2[hi - lo + 1];
                        int mx = Math.max(st[k][lo], st[k][hi - (1 << k) + 1]);
                        if (mx > NEG / 2) best = Math.max(best, mx);
                    }
                    gain = best;
                }
            }

            ans.set(qi, (int) (totalOnes + gain));
        }

        return ans;
    }
}
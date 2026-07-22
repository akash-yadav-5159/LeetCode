import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // Sparse Table for O(1) Range Minimum / Maximum Queries
    class SparseTable {
        int[][] st;
        int[] log2;
        boolean isMin;

        SparseTable(int[] arr, boolean isMin) {
            this.isMin = isMin;
            int n = arr.length;
            if (n == 0) return;
            
            log2 = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log2[i] = log2[i / 2] + 1;
            }
            
            int K = log2[n] + 1;
            st = new int[K][n];
            for (int i = 0; i < n; i++) {
                st[0][i] = arr[i];
            }
            for (int j = 1; j < K; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    if (isMin) {
                        st[j][i] = Math.min(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
                    } else {
                        st[j][i] = Math.max(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
                    }
                }
            }
        }

        int query(int L, int R) {
            if (L > R) return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int j = log2[R - L + 1];
            if (isMin) {
                return Math.min(st[j][L], st[j][R - (1 << j) + 1]);
            } else {
                return Math.max(st[j][L], st[j][R - (1 << j) + 1]);
            }
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }

        List<Integer> uList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                uList.add(start);
                vList.add(i - 1);
            } else {
                i++;
            }
        }

        int m = uList.size();
        int[] u = new int[m];
        int[] v = new int[m];
        int[] Z = new int[m];    // Z stores the sizes of '0' blocks
        for (int j = 0; j < m; j++) {
            u[j] = uList.get(j);
            v[j] = vList.get(j);
            Z[j] = v[j] - u[j] + 1;
        }

        int[] W = new int[Math.max(0, m - 1)]; // W stores lengths of '1' blocks bounded by '0's
        int[] S = new int[Math.max(0, m - 1)]; // S caches contiguous sum of adjacent '0' blocks
        for (int j = 0; j < m - 1; j++) {
            W[j] = u[j + 1] - v[j] - 1;
            S[j] = Z[j] + Z[j + 1];
        }

        SparseTable stZ = new SparseTable(Z, false);
        SparseTable stW = new SparseTable(W, true);
        SparseTable stS = new SparseTable(S, false);

        int q = queries.length;
        int[] ans = new int[q];

        for (int j = 0; j < q; j++) {
            int L = queries[j][0];
            int R = queries[j][1];

            // Agar zero blocks nahi hain, trade possible nahi hai
            if (m == 0) {
                ans[j] = totalOnes;
                continue;
            }

            // Binary search the first '0' block intersecting [L, R]
            int low = 0, high = m - 1, a = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (v[mid] >= L) {
                    a = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Binary search the last '0' block intersecting [L, R]
            low = 0; high = m - 1; 
            int b = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (u[mid] <= R) {
                    b = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Valid trade fails if < 2 distinct '0' blocks are present
            if (a == -1 || b == -1 || a >= b) {
                ans[j] = totalOnes;
                continue;
            }

            // Restrict bounds securely to the query domain clipping
            int zPrimeA = Math.min(v[a], R) - Math.max(u[a], L) + 1;
            int zPrimeB = Math.min(v[b], R) - Math.max(u[b], L) + 1;

            int m1 = Math.max(zPrimeA, zPrimeB);
            if (b - a > 1) {
                m1 = Math.max(m1, stZ.query(a + 1, b - 1));
            }

            int wMin = stW.query(a, b - 1);
            int maxAdj = 0;
            
            if (b == a + 1) {
                maxAdj = zPrimeA + zPrimeB;
            } else {
                maxAdj = Math.max(zPrimeA + Z[a + 1], Z[b - 1] + zPrimeB);
                if (b - a > 2) {
                    maxAdj = Math.max(maxAdj, stS.query(a + 1, b - 2));
                }
            }

            // Maximum net delta nikalna
            int gain = Math.max(maxAdj, m1 - wMin);
            ans[j] = totalOnes + gain;
        }

        // Aakhiri step: ans[] ko List<Integer> mein convert karna taaki return type match kare
        List<Integer> result = new ArrayList<>();
        for (int val : ans) {
            result.add(val);
        }
        
        return result;
    }
}
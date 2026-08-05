class Solution {
    public int uniquePaths(int m, int n) {
        // N = Total steps, R = Steps to go right (ya down)
        int N = m + n - 2;
        int R = Math.min(m - 1, n - 1); // Chhoti value lene se loop kam chalega
        
        long ans = 1; // long use kar rahe hain taaki intermediate calculation overflow na ho
        
        for (int i = 1; i <= R; i++) {
            ans = ans * (N - R + i) / i;
        }
        
        return (int) ans;
    }
}
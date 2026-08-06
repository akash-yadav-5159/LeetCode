class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (isProductDivisible(n, t)) {
                return n;
            }
            n++;
        }
    }
    private boolean isProductDivisible(int num, int t) {
        int product = 1;
        while (num > 0) {
            product *= (num % 10);
            if (product == 0) return true;
            num /= 10;
        }
        return product % t == 0;
    }
}
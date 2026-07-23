class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int powerOfTwo = 1;
        while (powerOfTwo <= n) {
            powerOfTwo = powerOfTwo << 1;
        }
        return powerOfTwo;
    }
}
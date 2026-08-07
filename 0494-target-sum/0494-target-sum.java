import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Edge Cases:
        // 1. Agar target totalSum se bada hai toh possible nahi hai.
        // 2. target + totalSum agar odd hai, toh usko 2 se divide nahi kar sakte (invalid).
        // 3. (target + totalSum) negative bhi nahi hona chahiye.
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0 || (totalSum + target) < 0) {
            return 0;
        }

        int s1 = (totalSum + target) / 2;

        // DP array initialize karo (Tumhara favourite style)
        int[][] dp = new int[s1 + 1][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countSubsets(nums, s1, 0, dp);
    }

    public int countSubsets(int[] nums, int targetSum, int index, int[][] dp) {
        // Base case: Jab end par pahunchein
        if (index == nums.length) {
            if (targetSum == 0) {
                return 1;
            }
            return 0;
        }

        if (targetSum < 0) {
            return 0;
        }

        if (dp[targetSum][index] != -1) {
            return dp[targetSum][index];
        }

        // Pick the current element
        int pick = countSubsets(nums, targetSum - nums[index], index + 1, dp);
        
        // Skip the current element
        int skip = countSubsets(nums, targetSum, index + 1, dp);

        // Store and return total ways
        dp[targetSum][index] = pick + skip;
        return dp[targetSum][index];
    }
}
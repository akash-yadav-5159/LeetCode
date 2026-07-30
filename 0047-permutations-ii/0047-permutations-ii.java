import java.util.*;

class Solution {
    public void helper(int index, int[] nums, List<List<Integer>> ans) {
        // Base Case: Raasta khatam, poora permutation ban gaya
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            
            // 🚀 TERA IDEA: Yahan hum check kar rahe hain
            // Agar yeh list pehle se ans mein nahi hai, tabhi add karo
            if (!ans.contains(ds)) {
                ans.add(ds);
            }
            return;
        }
        
        // Loop chalega, par ab koi rokne wala (HashSet/Condition) nahi hai
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            
            // Explore
            helper(index + 1, nums, ans);
            
            // Backtrack
            swap(i, index, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Is approach mein array ko sort karne ki bhi zaroorat nahi hai, 
        // kyunki .contains() khud hi check kar lega!
        helper(0, nums, ans);
        return ans;
    }
}
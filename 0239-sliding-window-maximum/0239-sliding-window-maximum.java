class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new ArrayDeque<>();
        int ans[]=new int[nums.length-k+1];
        int ansIdx=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                ans[ansIdx++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
class Solution {
    public int trap(int[] height) {
        int collect=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty()&&height[i]>height[st.peek()]){
                int base=st.pop();
                if(st.isEmpty()){
                    break;
                }
                int leftindex=st.peek();
                int width=i-leftindex-1;
                int bheight=Math.min(height[i],height[leftindex])-height[base];
                collect+=width*bheight;
            }
            st.push(i);
        }
        return collect;
    }
}
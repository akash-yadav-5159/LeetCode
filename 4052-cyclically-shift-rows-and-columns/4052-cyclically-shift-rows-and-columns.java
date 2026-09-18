class Solution {
    public void reverse(int arr[],int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for(int i=0;i<n;i++){
            reverse(grid[i],0,rowShift[i]-1);
            reverse(grid[i],rowShift[i],n-1);
            reverse(grid[i],0,n-1);
        }
        for(int i=0;i<n;i++){
            int nums[]=new int[n];
            for(int j=0;j<n;j++){
                nums[j]=grid[j][i];
            }
            reverse(nums,0,colShift[i]-1);
            reverse(nums,colShift[i],n-1);
            reverse(nums,0,n-1);
            for(int j=0;j<n;j++){
                grid[j][i]=nums[j];
            }
        }
        return grid;
    }
}
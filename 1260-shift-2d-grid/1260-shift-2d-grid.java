class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        int len=k%(m*n);
        int row[]=new int[m*n];
        int l=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[l]=grid[i][j];
                l++;
            }
        }
        if(len==0)len=m*n;
        int x=m*n-len;
        List<Integer>temp=new ArrayList<>();
        for(int i=x;i<row.length+x;i++){
            temp.add(row[i%row.length]);
            if(temp.size()==n){
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return ans;
    }
}
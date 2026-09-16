class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int min=0;
        int direction[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int j=0;j<direction.length;j++){
                    int nr=r+direction[j][0];
                    int nc=c+direction[j][1];
                    if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==1){
                        fresh--;
                        q.add(new int[]{nr,nc});
                        grid[nr][nc]=2;
                    }
                }
            }
            min++;
        }
        return fresh==0?min:-1;
    }
}
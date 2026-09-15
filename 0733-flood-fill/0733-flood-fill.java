class Solution {
    public void dfs(int [][]image, boolean vis[][], int sr, int sc,int comp){
        vis[sr][sc]=true;
        if(sr!=0&&!vis[sr-1][sc]&&image[sr-1][sc]==comp){
            dfs(image,vis,sr-1,sc,comp);
        }
        if(sr!=image.length-1&&!vis[sr+1][sc]&&image[sr+1][sc]==comp){
            dfs(image,vis,sr+1,sc,comp);
        }
        if(sc!=0&&!vis[sr][sc-1]&&image[sr][sc-1]==comp){
            dfs(image,vis,sr,sc-1,comp);
        }
        if(sc!=image[0].length-1&&!vis[sr][sc+1]&&image[sr][sc+1]==comp){
            dfs(image,vis,sr,sc+1,comp);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][]=new boolean[image.length][image[0].length];
        int comp=image[sr][sc];
        if(comp==color)return image;
        dfs(image,vis,sr,sc,comp);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(vis[i][j]){
                    image[i][j]=color;
                }
            }
        }
        return image;
    }
}

class Solution {
    public void dfs(int [][]image, int sr, int sc,int comp,int color){
        image[sr][sc]=color;
        if(sr!=0&&image[sr-1][sc]==comp){
            dfs(image,sr-1,sc,comp,color);
        }
        if(sr!=image.length-1&&image[sr+1][sc]==comp){
            dfs(image,sr+1,sc,comp,color);
        }
        if(sc!=0&&image[sr][sc-1]==comp){
            dfs(image,sr,sc-1,comp,color);
        }
        if(sc!=image[0].length-1&&image[sr][sc+1]==comp){
            dfs(image,sr,sc+1,comp,color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int comp=image[sr][sc];
        if(comp==color)return image;
        dfs(image,sr,sc,comp,color);
        return image;
    }
}

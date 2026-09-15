class Solution {
    int count;
    public void dfs(List<List<Integer>> rooms,boolean vis[],int source){
        count++;
        vis[source]=true;
        for(int i=0;i<rooms.get(source).size();i++){
            if(!vis[rooms.get(source).get(i)]){
                dfs(rooms,vis,rooms.get(source).get(i));
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        count=0;
        boolean vis[]=new boolean[rooms.size()];
        dfs(rooms,vis,0);
        if(count==rooms.size())return true;
        return false;
    }
}
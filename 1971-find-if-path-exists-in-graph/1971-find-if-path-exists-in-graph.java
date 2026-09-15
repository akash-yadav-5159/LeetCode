class Solution {
    public boolean dfs(int source, ArrayList<ArrayList<Integer>>graph, int dest,boolean vis[]){
        if(source==dest)return true;
        vis[source]=true;
        for(int i=0;i<graph.get(source).size();i++){
            if(!vis[graph.get(source).get(i)]){
                if(dfs(graph.get(source).get(i),graph,dest,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[]=new boolean[n];
        return dfs(source,graph,destination,vis);
    }
}
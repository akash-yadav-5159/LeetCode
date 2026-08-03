class Solution {
    public int ans(String s, int arr[], int idx){
        if(idx==s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        if(arr[idx]!=-1)return arr[idx];
        int ways=ans(s,arr,idx+1);
        if((idx+1)<s.length()){
            int first=s.charAt(idx)-'0';
            int second=s.charAt(idx+1)-'0';
            int num=first*10+second;
            if(1<=num&&num<=26){
                ways+=ans(s,arr,idx+2);
            }
        }
        return arr[idx]=ways;
    }
    public int numDecodings(String s) {
        int arr[]=new int[s.length()+1];
        Arrays.fill(arr,-1);
        return ans(s,arr,0);
    }
}
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder finals=new StringBuilder();
        int count=0;
        int start=0;
        int fixstart=0;
        int fixend=0;
        boolean x=true;
        int len=s.length()+1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='1')count++;
            while(start <= j && s.charAt(start) == '0') {
                start++;
            }
            if(count==k){
                x=false;
                if((j-start+1)<len){
                    len=j-start+1;
                    fixstart=start;
                    fixend=j;
                } else if (j-start+1 == len) {
                    String currentStr = s.substring(start, j + 1);
                    String bestStr = s.substring(fixstart, fixend + 1);
                    if(currentStr.compareTo(bestStr) < 0) {
                        fixstart = start;
                        fixend = j;
                    }
                }
                int subcount=0;
                for(int i=start;i<=j;i++){
                    if(s.charAt(i)=='1')subcount++;
                    if(subcount==2){
                        start=i;
                        break;
                    }
                }
                count=k-1;
            }
        }
        if(x)return "";
        for(int i=fixstart;i<=fixend;i++){
            finals.append(s.charAt(i));
        }
        return finals.toString();
    }
}
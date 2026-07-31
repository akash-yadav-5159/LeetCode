class Solution {
    public int minimumPushes(String word) {
        int map[]=new int[26];
        for(int i=0;i<word.length();i++){
            map[word.charAt(i)-'a']++;
        }
        Arrays.sort(map);
        int count=0;
        int j=0;
        for(int i=25;i>=0;i--){
            if(map[i]==0)break;
            count=count+(j/8+1)*map[i];
            j++;

        }
        return count;
    }
}
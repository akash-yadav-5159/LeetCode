class Solution {
    public boolean isAnagram(String s, String t) {
        char T[]=t.toCharArray();
        char S[]=s.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        if(Arrays.equals(S,T))return true;
        return false;
    }
}
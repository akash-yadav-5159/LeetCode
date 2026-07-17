class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        if(s.length()==0)return true;
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()&&(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}')){
                return false;
            }else if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if((s.charAt(i)==')'&&st.peek()=='(')||(s.charAt(i)=='}'&&st.peek()=='{')||(s.charAt(i)==']'&&st.peek()=='[')){
                st.pop();
            }else{
                return false;
            }
        }
        if(!st.isEmpty())return false;
        return true;
    }
}
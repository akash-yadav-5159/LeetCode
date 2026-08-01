class Solution {
    public void all(List<List<String>>list,List<String>list2,String s,int index){
        if(index==s.length()){
            list.add(new ArrayList<>(list2));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list2.add(s.substring(index,i+1));
                all(list,list2,s,i+1);
                list2.remove(list2.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int index, int i){
        while(index<i){
            if(s.charAt(index)!=s.charAt(i))return false;
            index++;
            i--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>list=new ArrayList<>();
        List<String>list2=new ArrayList<>();
        all(list,list2,s,0);
        return list;
    }
}
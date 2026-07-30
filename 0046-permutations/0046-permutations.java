class Solution {
    public void permutation(List<List<Integer>>list, List<Integer>list2, List<Integer>LIST){
        if(LIST.size()==0){
            list.add(new ArrayList<>(list2));
        }
        for(int i=0;i<LIST.size();i++){
            int x=LIST.get(i);
            list2.add(x);
            LIST.remove(i);
            permutation(list,list2,LIST);
            list2.removeLast();
            LIST.add(i,x);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>LIST=Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer>list2=new ArrayList<>();
        permutation(list,list2,LIST);
        return list;
    }
}
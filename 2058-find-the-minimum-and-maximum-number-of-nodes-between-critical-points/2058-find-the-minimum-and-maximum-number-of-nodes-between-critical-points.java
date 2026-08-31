/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null||head.next==null)return new int[]{-1,-1};
        ArrayList<Integer>list=new ArrayList<>();
        int size=2;
        while(head.next.next!=null){
            if((head.val>head.next.val&&head.next.next.val>head.next.val)||(head.val<head.next.val&&head.next.next.val<head.next.val)){
                list.add(size);
            }
            head=head.next;
            size++;
        }
        if(list.size()<2)return new int[]{-1,-1};
        int max=list.get(list.size()-1)-list.get(0);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min=Math.min(min,list.get(i)-list.get(i-1));
        }
        return new int[]{min,max};
        
    }
}
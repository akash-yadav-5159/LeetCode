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
        int size=1;
        int prevCritical=-1;
        int firstCritical=-1;
        int minDistance=Integer.MAX_VALUE;
        while(head.next.next!=null){
            if((head.val>head.next.val&&head.next.next.val>head.next.val)||(head.val<head.next.val&&head.next.next.val<head.next.val)){
                if(firstCritical==-1){
                    firstCritical=size;
                }else{
                    minDistance=Math.min(minDistance,size-prevCritical);
                }
                prevCritical=size;
            }
            head=head.next;
            size++;
        }
        if(minDistance==Integer.MAX_VALUE)return new int []{-1,-1};
        int maxDistance=prevCritical-firstCritical;
        return new int[]{minDistance,maxDistance};
        
    }
}
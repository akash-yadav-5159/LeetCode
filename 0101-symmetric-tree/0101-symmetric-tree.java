/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean check(TreeNode x, TreeNode y){
        if(x==null&&y==null)return true;
        if((x==null||y==null)||x.val!=y.val)return false;
        boolean a=check(x.left,y.right);
        boolean b=check(x.right,y.left);
        return a&&b;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(root.left==null&&root.right==null)return true;
        if(root.left==null||root.right==null)return false;
        if(root.left.val==root.right.val){
            return check(root.left,root.right);
        }
        return false;
    }
}
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
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer,TreeNode> tree = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for(int comp[] : descriptions )
        {
            tree.putIfAbsent(comp[0],new TreeNode(comp[0]));
            tree.putIfAbsent(comp[1],new TreeNode(comp[1]));

            children.add(comp[1]);

            if(comp[2]==1)
            {
                tree.get(comp[0]).left=tree.get(comp[1]);
            }else
            {
                tree.get(comp[0]).right=tree.get(comp[1]);
            }
        }

        TreeNode ans=null;

        for(int[] d : descriptions)
        {
            int parentVal = d[0];

            if(!children.contains(parentVal))
            {
                return tree.get(parentVal);
            }
        }
        

        return ans;
        
    }
}
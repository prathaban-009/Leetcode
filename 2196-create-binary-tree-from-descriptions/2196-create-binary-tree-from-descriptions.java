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
   
    public TreeNode createBinaryTree(int[][] des) {

        HashMap<Integer,TreeNode> tree=new HashMap<>();

        HashSet<Integer> children = new HashSet<>();
        // TreeNode root;


        for(int i=0;i<des.length;i++)
        {
            if(!tree.containsKey(des[i][0]))
            {
                TreeNode newNode=new TreeNode(des[i][0]);
                tree.put(des[i][0],newNode);
                // root.put(des[i][0],newNode);
                 
            }

            
            if(!tree.containsKey(des[i][1]))
            {
                TreeNode newNode=new TreeNode(des[i][1]);
                tree.put(des[i][1],newNode);

                
                // if(root.containsKey(des[i][1]))
                // {
                //     root.remove(des[i][1]);
                // }

            }

            if(des[i][2]==1)
            {
                TreeNode left=tree.get(des[i][1]);
                TreeNode parent=tree.get(des[i][0]);
                children.add(des[i][1]);
                parent.left=left;
            }else
            {
                TreeNode right=tree.get(des[i][1]);
                TreeNode parent=tree.get(des[i][0]);
                children.add(des[i][1]);
                parent.right=right;
            }

            
        }
        TreeNode ans=null;
        
        for(int arr[] : des)
        {
            if(!children.contains(arr[0]))
            ans=tree.get(arr[0]);
        }
        return ans;
    }
}
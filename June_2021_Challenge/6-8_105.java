// 105. Construct Binary Tree from Preorder and Inorder Traversal

// - preorder, root came first
// - inorder, root came in middle between its right and left children
// - took root from preorder, then user inorder to connect its children


class Solution {
    int preIdx=0;
    HashMap<Integer, Integer> inorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIdx = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inorderIdx.put(inorder[i],i);
        return dfs(0, inorder.length-1, preorder);
        
    }
    private TreeNode dfs(int l, int r, int[] preorder){
        if(l>r) return null;
        TreeNode root= new TreeNode(preorder[preIdx++]);
        int mid = inorderIdx.get(root.val);
        root.left = dfs(l, mid-1, preorder);
        root.right = dfs(mid+1, r,preorder);
        return root;
        
    }
}

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
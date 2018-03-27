package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

/**
 * description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * @author Hehongyu
 * @date 4:02 PM 27/3/2018
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        // 此处可以简化为一行：return root != null && (sum == root.val && root.left == null && root.right == null
        //              || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
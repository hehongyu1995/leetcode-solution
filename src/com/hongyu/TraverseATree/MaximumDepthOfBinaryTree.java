package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

/**
 * description: 二叉树最大深度
 *
 * @author Hehongyu
 * @date 3:47 PM 27/3/2018
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }
}

package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description: 二叉树的中序遍历
 *
 * @author Hehongyu
 * @date 5:19 PM 26/3/2018
 */
public class BinaryTreeInorderTraversal {
    /**
     * 循环遍历
     * 1. 若root不为空或栈不为空则继续遍历
     * 2. 若root不为空，则继续将root的左节点赋值给root，并将root入栈，继续遍历。
     * 3. 若root为空，说明当前节点的左子树已经遍历结束，将当前节点出栈，打印左节点值，打印当前节点值，并将右节点赋值给root，继续遍历
     * 4. 重复1
     *
     * @param root
     * @return
     */
    List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}

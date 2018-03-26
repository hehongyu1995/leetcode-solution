package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description: 前序遍历
 *
 * @author Hehongyu
 * @date 3:23 PM 26/3/2018
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        // write your code here
    }

    List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseTree(root, result);
        return result;
    }

    /**
     * 循环遍历
     * 1 root不为空或栈不为空，则继续遍历
     * 2 如果root不为空，则将root的值打印，将root入栈，将root置为左子树，继续遍历
     * 3 如果root为空，说明已经遍历完当前栈节点的左子树，将当前栈节点出栈并赋值右子树给root，继续遍历右子树
     * 4 重复1
     */
    List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }

    /**
     * 递归遍历
     *
     * @param root
     * @param result
     */
    private void traverseTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverseTree(root.left, result);
        traverseTree(root.right, result);
    }
}

package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.Stack;

/**
 * description: 判断是否是对称二叉树
 *
 * @author Hehongyu
 * @date 4:02 PM 27/3/2018
 */
public class SymmetricTree {
    /**
     * 递归求解
     *
     * @param root
     * @return
     */
    public boolean isSymmetricRecursively(TreeNode root) {
        return root == null || judgeRecursively(root.left, root.right);
    }

    private boolean judgeRecursively(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && judgeRecursively(left.left, right.right) && judgeRecursively(left.right, right.left);
        } else {
            return left == null && right == null;
        }
    }

    /**
     * 循环求解
     *
     * @param root
     * @return
     */
    private boolean isSymmetricIteratively(TreeNode root) {
        // 如果根节点为null，对称
        if (root == null) {
            return true;
        }
        // 如果左右子树都不为空，继续判断
        if (root.left != null && root.right != null) {
            Stack<TreeNode> s = new Stack<>();
            // 左右子树入栈
            s.add(root.left);
            s.add(root.right);
            while (!s.empty()) {
                // 每次从栈中取两个节点进行判断
                TreeNode node1 = s.pop();
                TreeNode node2 = s.pop();
                if (node1 != null && node2 != null) {
                    if (node1.val != node2.val) {
                        return false;
                    }
                    s.push(node1.left);
                    s.push(node2.right);
                    s.push(node1.right);
                    s.push(node2.left);
                } else if (node1 == null && node2 == null) {
                    // 两个都为空啥也不用做
                } else {
                    // 一个为空一个不为空，肯定不对称
                    return false;
                }
            }
            // 循环结束，说明没有不对称情况出现，返回true
            return true;
        } else {
            // 如果左右子树都为空，对称
            return root.left == null && root.right == null;
        }

    }
}

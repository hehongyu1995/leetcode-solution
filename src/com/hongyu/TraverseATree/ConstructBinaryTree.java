package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.Stack;

/**
 * 从遍历结果构建二叉树
 */
public class ConstructBinaryTree {
    /**
     * 从中序遍历和后序遍历的结果数组构建二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTreeWithInAndPost(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        Stack<TreeNode> sNode = new Stack<>();
        Stack<Integer> sIndex = new Stack<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        sNode.push(root);
        sIndex.push(findInArray(root.val, inorder));
        for (int i = postorder.length - 2; i >= 0; i--) {
            int valNew = postorder[i];
            int indexNew = findInArray(valNew, inorder);
            TreeNode nodeNew = new TreeNode(valNew);
            // 编号小于当前子树的值编号，说明为当前子树的右子树.
            // 赋值新node给当前节点的右子树
            if (indexNew > sIndex.peek()) {
                sNode.peek().right = nodeNew;
                sNode.push(nodeNew);
                sIndex.push(indexNew);
            } else {
                TreeNode nodeTemp = sNode.peek();
                // 循环查找，直到最后一个在当前节点左边的节点
                while (sIndex.size() > 0 && indexNew < sIndex.peek()) {
                    sIndex.pop();
                    nodeTemp = sNode.pop();
                }
                nodeTemp.left = nodeNew;
                sNode.push(nodeNew);
                sIndex.push(indexNew);
            }
        }
        return root;
    }

    private static int findInArray(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从前序遍历和中序遍历的结果数组构建二叉树（思路和后序类似）
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeWithPreAndIn(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> sNode = new Stack<>();
        Stack<Integer> sIndex = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        sNode.push(root);
        sIndex.push(findInArray(root.val, inorder));
        for (int i = 1; i < preorder.length; i++) {
            int valNew = preorder[i];
            int indexNew = findInArray(valNew, inorder);
            TreeNode nodeNew = new TreeNode(valNew);
            if (indexNew < sIndex.peek()) {
                sNode.peek().left = nodeNew;
                sNode.push(nodeNew);
                sIndex.push(indexNew);
            } else {
                TreeNode nodeTemp = sNode.peek();
                while (sIndex.size() > 0 && indexNew > sIndex.peek()) {
                    sIndex.pop();
                    nodeTemp = sNode.pop();
                }
                nodeTemp.right = nodeNew;
                sNode.push(nodeNew);
                sIndex.push(indexNew);
            }
        }
        return root;
    }
}
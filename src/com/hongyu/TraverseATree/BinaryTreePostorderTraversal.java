package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description: 二叉树后序遍历
 *
 * @author Hehongyu
 * @date 5:37 PM 26/3/2018
 */
public class BinaryTreePostorderTraversal {

    /**
     * 循环遍历
     * 1. 一直沿着左子树遍历，并一一加入stack中，知道左子树为空。
     * 2. 如果stack不为空，则进入循环。pop栈中节点，赋值给curNode。
     * 3. 当前节点的右子树不为空且右子树不等于上次访问的节点时，将当前节点入栈，并沿着右子树左边遍历，并一一加入栈中。
     * 否则说明当前节点的右子树为空或已经被访问过，该节点的值可以被访问。添加当前节点的值到遍历结果中，
     * 并将当前节点的引用保存到lastVisitNode，方便下次判断右子树是否已访问。
     * 4. 重复2
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> rootStack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisitNode = null;
        while (curNode != null) {
            rootStack.push(curNode);
            curNode = curNode.left;
        }
        while (!rootStack.empty()) {
            curNode = rootStack.pop();
            if (curNode.right != null && curNode.right != lastVisitNode) {
                rootStack.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    rootStack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                result.add(curNode.val);
                lastVisitNode = curNode;
            }
        }
        return result;
    }
}

package com.hongyu.TraverseATree;

import com.hongyu.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: 二叉树的广度优先遍历
 *
 * @author Hehongyu
 * @date 9:53 PM 26/3/2018
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 1. root节点首先入队列
     * 2. 当队列不为空时，进入循环。创建当前层级的curLevel List，遍历当前的队列，每个节点出队列，
     * 并将值加入curLevel，并加入curLevel的左右节点到队列中。
     * 3. 将curLevel加入result List中
     * 4. 重复2
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int sizeQ = q.size();
            for (int i = 0; i < sizeQ; i++) {
                TreeNode curNode = q.remove();
                curLevel.add(curNode.val);
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            result.add(curLevel);
        }
        return result;

    }
}

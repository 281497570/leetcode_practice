package org.lj.ds.tree.leetcode;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 98. Validate Binary Search Tree <br>
 * https://leetcode.com/problems/validate-binary-search-tree/ <br>
 */
@Slf4j
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        // TreeNode root = TreeUtil.createTreeNode(new int[] { 2, 1, 3 });
        // TreeNode root = TreeUtil.createTreeNode(new int[] { 1, 1 });
        TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 100, 50, 150, -1, 51, 101, 200 });
        log.info("isValidBST: {}", new ValidateBinarySearchTree().isValidBST(root));
    }

    /**
     * 二叉搜索树在中序遍历的情况下，元素是一个升序排列
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Integer lastValue = null;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        while (node != null || !stack.isEmpty()) {
            // 根、左子节点入栈
            while (node != null) {
                stack.offerLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pollLast();
                if (lastValue == null) {
                    lastValue = node.val;
                } else if (lastValue >= node.val) {
                    //
                    return false;
                }

                lastValue = node.val;
                node = node.right;
            }
        }
        return true;
    }

    // TODO 递归求解
}

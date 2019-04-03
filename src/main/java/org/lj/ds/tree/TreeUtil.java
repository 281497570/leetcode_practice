package org.lj.ds.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;

/**
 * PreOrder
 */
public class TreeUtil {
    public static TreeNode[] createTreeNode(int N) {
        TreeNode[] nodes = new TreeNode[N];
        for (int i = 0; i < N; ++i) {
            nodes[i] = new TreeNode(i + 1, null, null);
        }
        return nodes;
    }

    public static TreeNode[] createTreeNode(Integer... nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(nums[i], null, null);
            }
        }

        return nodes;
    }

    public static TreeNode createCompleteBinaryTree(Integer... nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(nums[i], null, null);
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            if (node == null) {
                continue;
            }
            node.left = i * 2 + 1 > nodes.length - 1 ? null : nodes[i * 2 + 1];
            node.right = i * 2 + 2 > nodes.length - 1 ? null : nodes[i * 2 + 2];
        }

        return nodes.length > 0 ? nodes[0] : null;
    }

    public static TreeNode searchTree(TreeNode root, int data) {
        if (root == null || root.val == data) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.val == data) {
                    return node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.left != null) {
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }
}

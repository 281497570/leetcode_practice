package org.lj.ds.tree;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * DFSPreOrder <br>
 * 深度优先搜索 - 先序遍历<br>
 */
@Slf4j
public class DFSPreOrder {

    public static void main(String[] args) {

        TreeNode[] nodes = TreeUtil.createTreeNode(7);

        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        stack.offerLast(nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            node.left = i * 2 + 1 > nodes.length - 1 ? null : nodes[i * 2 + 1];
            node.right = i * 2 + 2 > nodes.length - 1 ? null : nodes[i * 2 + 2];
        }

        new DFSPreOrder().preOrderRecursion(nodes[0]);
        new DFSPreOrder().preOrderIteration(nodes[0]);
    }

    public void preOrderRecursion(TreeNode root) {
        if (root != null) {
            log.info("data:{}", root.val);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    public void preOrderIteration(TreeNode root) {
        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            // 弹出最后一个元素
            TreeNode node = stack.pollLast();
            log.info("data:{}", node.val);

            // 右子树入栈
            if (node.right != null) {
                stack.offerLast(node.right);
            }

            // 左子树入栈（保证最后一个元素一定时左子树）
            if (node.left != null) {
                stack.offerLast(node.left);
            }
        }
    }
}

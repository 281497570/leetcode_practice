package org.lj.ds.tree;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * DFSPostOrder
 */
@Slf4j
public class DFSPostOrder {
    public static void main(String[] args) {
        TreeNode[] nodes = TreeUtil.createTreeNode(7);

        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        stack.offerLast(nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            node.left = i * 2 + 1 > nodes.length - 1 ? null : nodes[i * 2 + 1];
            node.right = i * 2 + 2 > nodes.length - 1 ? null : nodes[i * 2 + 2];
        }

        new DFSPostOrder().postOrderRecursion(nodes[0]);
        new DFSPostOrder().postOrderIteration(nodes[0]);
    }

    public void postOrderRecursion(TreeNode root) {
        if (root != null) {
            postOrderRecursion(root.left);
            postOrderRecursion(root.right);
            log.info("data:{}", root.val);
        }
    }

    // TODO 非递归求解
    public void postOrderIteration(TreeNode root) {
    }
}

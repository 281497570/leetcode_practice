package org.lj.ds.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * DFSInOrder <br>
 * 深度优先搜索 - 中序遍历<br>
 */
@Slf4j
public class DFSInOrder {

    public static void main(String[] args) {

        TreeNode[] nodes = TreeUtil.createTreeNode(7);

        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        stack.offerLast(nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            node.left = i * 2 + 1 > nodes.length - 1 ? null : nodes[i * 2 + 1];
            node.right = i * 2 + 2 > nodes.length - 1 ? null : nodes[i * 2 + 2];
        }

        new DFSInOrder().inOrderRecursion(nodes[0]);
        new DFSInOrder().inOrderIteration(nodes[0]);
        log.info("{}", new DFSInOrder().inorderTraversal(nodes[0]));
    }

    public void inOrderRecursion(TreeNode root) {
        if (root != null) {
            inOrderRecursion(root.left);
            log.info("data:{}", root.val);
            inOrderRecursion(root.right);
        }
    }

    public void inOrderIteration(TreeNode root) {
        Deque<TreeNode> stack = new LinkedBlockingDeque<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // 根节点 & 左子节点入栈
            while (node != null) {
                stack.offerLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                // 运行到此处时说明已经到了根节点 | 左子节点
                node = stack.pollLast();
                log.info("data:{}", node.val);

                // 递归遍历右子树
                node = node.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedBlockingDeque<>();
        while (p != null || !stack.isEmpty()) {
            // 将左子树入栈
            while (p != null) {
                stack.offerLast(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                // 访问最左子树
                TreeNode pn = stack.pollLast();
                list.add(pn.val);

                // 开始递归右子树
                p = pn.right;
            }
        }
        return list;
    }
}

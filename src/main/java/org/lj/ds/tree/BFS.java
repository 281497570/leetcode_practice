package org.lj.ds.tree;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import org.lj.ds.model.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * BFS
 */
@Slf4j
public class BFS {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        new BFS().bfs(root);
        new BFS().bfsWithLevel(root);
    }

    public void bfs(TreeNode root) {
        Deque<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            log.info("{}", node.val);

            if (node.left != null) {
                queue.offerLast(node.left);
            }
            if (node.right != null) {
                queue.offerLast(node.right);
            }
        }
    }

    public void bfsWithLevel(TreeNode root) {
        Deque<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offerLast(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 将当前层一次性输出
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.pollFirst();
                log.info("{} - {}", level, node.val);

                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            level++;
        }
    }
}

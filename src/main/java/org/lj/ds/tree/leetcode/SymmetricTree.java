package org.lj.ds.tree.leetcode;

import java.util.LinkedList;

import org.junit.Assert;
import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 101. Symmetric Tree
 * <p>
 * https://leetcode.com/problems/symmetric-tree/
 */
@Slf4j
public class SymmetricTree {

    public static void main(String[] args) {
        {
            TreeNode p = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2, 2, 3, 4, 4, 3 });
            boolean output = new SymmetricTree().isSymmetric(p);
            log.info("output:{}", output);
            Assert.assertEquals(true, output);
        }
        {
            TreeNode p = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2, 2, null, 3, null, 3 });
            boolean output = new SymmetricTree().isSymmetric(p);
            log.info("output:{}", output);
            Assert.assertEquals(false, output);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 对比本层的节点是否对称
            for (int i = len / 2 - 1, j = len / 2; i > -1 && j < len; i--, j++) {
                TreeNode left = queue.get(i);
                TreeNode right = queue.get(j);
                if (!isMatch(left, right)) {
                    return false;
                }
            }

            // 将本层的子节点加入队列
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }
        return true;
    }

    private boolean isMatch(TreeNode left, TreeNode right) {
        return left == right || (left != null && right != null && left.val == right.val);
    }
}

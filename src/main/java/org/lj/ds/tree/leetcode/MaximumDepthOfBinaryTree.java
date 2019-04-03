package org.lj.ds.tree.leetcode;

import org.junit.Assert;
import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 111. Minimum Depth of Binary Tree
 * <p>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
@Slf4j
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
            int maxDepth = new MaximumDepthOfBinaryTree().maxDepth(root);
            log.info("maxDepth:{}", maxDepth);
            Assert.assertEquals(3, maxDepth);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2 });
            int maxDepth = new MaximumDepthOfBinaryTree().maxDepth(root);
            log.info("maxDepth:{}", maxDepth);
            Assert.assertEquals(2, maxDepth);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2, null, 4, null, null, null, 8 });
            int maxDepth = new MaximumDepthOfBinaryTree().maxDepth(root);
            log.info("maxDepth:{}", maxDepth);
            Assert.assertEquals(4, maxDepth);
        }
    }

    /**
     * <p>
     * 子问题：求出当前层的最大深度 + 1
     * <p>
     * 终止条件：根节点为nul
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // TODO 非递归求解
}

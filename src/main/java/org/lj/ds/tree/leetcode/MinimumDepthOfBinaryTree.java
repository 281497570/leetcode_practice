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
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
            int minDepth = new MinimumDepthOfBinaryTree().minDepth(root);
            log.info("minDepth:{}", minDepth);
            Assert.assertEquals(2, minDepth);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2 });
            int minDepth = new MinimumDepthOfBinaryTree().minDepth(root);
            log.info("minDepth:{}", minDepth);
            Assert.assertEquals(2, minDepth);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2, null, 4, null, null, null, 8 });
            int minDepth = new MinimumDepthOfBinaryTree().minDepth(root);
            log.info("minDepth:{}", minDepth);
            Assert.assertEquals(4, minDepth);
        }
    }

    /**
     * <p>
     * 子问题：求出当前层的最小深度 + 1
     * <p>
     * 终止条件：根节点为nul
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            // 如果左或右子树为空，则取深度最大的，否则当层深度失真
            return 1 + Math.max(left, right);
        } else {
            // 取最小深度
            return 1 + Math.min(left, right);
        }
    }

    // TODO 非递归求解
}

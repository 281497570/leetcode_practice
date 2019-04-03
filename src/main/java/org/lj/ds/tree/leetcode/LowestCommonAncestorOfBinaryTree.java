package org.lj.ds.tree.leetcode;

import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
@Slf4j
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
            TreeNode p = TreeUtil.searchTree(root, 5);
            TreeNode q = TreeUtil.searchTree(root, 1);
            TreeNode ancestor = new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, p, q);
            log.info("ancenstor:{}", ancestor == null ? null : ancestor.val);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
            TreeNode p = TreeUtil.searchTree(root, 5);
            TreeNode q = TreeUtil.searchTree(root, 4);
            TreeNode ancestor = new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, p, q);
            log.info("ancenstor:{}", ancestor == null ? null : ancestor.val);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断是否找到p或q
        if (root == null || root == p || root == q) {
            return root;
        }
        // 在左子树中判断p或q是否存在
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中判断p或q是否存在
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 均不为空则返回root节点
        if (left != null && right != null) {
            return root;
        }
        //
        return left == null ? right : left;
    }

    // TODO 非递归求解
}

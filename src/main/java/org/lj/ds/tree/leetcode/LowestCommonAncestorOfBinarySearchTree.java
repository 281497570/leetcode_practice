package org.lj.ds.tree.leetcode;

import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree <br>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <br>
 */
@Slf4j
public class LowestCommonAncestorOfBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
        {
            TreeNode p = TreeUtil.searchTree(root, 2);
            TreeNode q = TreeUtil.searchTree(root, 8);
            TreeNode ancestor = new LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor(root, p, q);
            log.info("ancenstor:{}", ancestor == null ? null : ancestor.val);
        }

        {
            TreeNode p = TreeUtil.searchTree(root, 2);
            TreeNode q = TreeUtil.searchTree(root, 4);
            TreeNode ancestor = new LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor(root, p, q);
            log.info("ancenstor:{}", ancestor == null ? null : ancestor.val);
        }
    }

    /**
     * 根据二叉搜索树的特性，只需判断p和q是否大于、小于root即可
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    // TODO 非递归求解
}

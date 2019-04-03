package org.lj.ds.tree.leetcode;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Assert;
import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 100. Same Tree
 * <p>
 * https://leetcode.com/problems/same-tree/
 */
@Slf4j
public class SameTree {

    public static void main(String[] args) {
        {
            TreeNode p = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2 });
            TreeNode q = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, null, 2 });
            boolean output = new SameTree().isSameTree(p, q);
            log.info("output:{}", output);
            Assert.assertEquals(true, output);
        }
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // 同时为空
        if (p == q) {
            return true;
        }
        // 形状不等 || 值不等
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // 递归判断左、右子树是否符合边界条件
        return isSameTree(p.left, q.left) ? isSameTree(p.right, q.right) : false;
    }

    /**
     * 用中序非递归遍历判断
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> pStack = new LinkedBlockingDeque<>();
        Deque<TreeNode> qStack = new LinkedBlockingDeque<>();
        while ((p != null || !pStack.isEmpty()) || (q != null || !qStack.isEmpty())) {
            while (p != null || q != null) {
                if (p == null || q == null) {
                    return false;
                }
                pStack.offerLast(p);
                p = p.left;
                qStack.offerLast(q);
                q = q.left;
            }

            if (!pStack.isEmpty() && !qStack.isEmpty()) {
                TreeNode pn = pStack.pollLast();
                TreeNode qn = qStack.pollLast();
                if (pn == null || qn == null || pn.val != qn.val) {
                    return false;
                }
                p = pn.right;
                q = qn.right;
            }
        }
        return pStack.isEmpty() && qStack.isEmpty();
    }
}

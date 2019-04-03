package org.lj.ds.tree.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.lj.ds.model.TreeNode;
import org.lj.ds.tree.TreeUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO NOT PASS
 * <p>
 * 987. Vertical Order Traversal of a Binary Tree
 * <p>
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
@Slf4j
public class VerticalOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
            List<List<Integer>> output = new VerticalOrderTraversalOfBinaryTree().verticalTraversal(root);
            log.info("output:{}", output);

            List<List<Integer>> excepted = Arrays.asList(Arrays.asList(9), Arrays.asList(3, 15), Arrays.asList(20),
                    Arrays.asList(7));
            Assert.assertEquals(excepted, output);
        }
        {
            TreeNode root = TreeUtil.createCompleteBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            List<List<Integer>> output = new VerticalOrderTraversalOfBinaryTree().verticalTraversal(root);
            log.info("output:{}", output);

            List<List<Integer>> excepted = Arrays.asList(Arrays.asList(4), Arrays.asList(2), Arrays.asList(1, 5, 6),
                    Arrays.asList(3), Arrays.asList(7));
            Assert.assertEquals(excepted, output);
        }
        {
            // leetcode 给的不是一颗完全二叉树
            TreeNode root = TreeUtil.createCompleteBinaryTree(
                    new Integer[] { 0, 8, 1, null, null, 3, 2, null, 4, 5, null, null, 7, 6 });
            List<List<Integer>> output = new VerticalOrderTraversalOfBinaryTree().verticalTraversal(root);
            log.info("output:{}", output);

            List<List<Integer>> excepted = Arrays.asList(Arrays.asList(8), Arrays.asList(0, 3, 6),
                    Arrays.asList(1, 4, 5), Arrays.asList(2, 7));
            Assert.assertEquals(excepted, output);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int minLevel = verticalTraversal0(root, map, 0);

        List<List<Integer>> result = new ArrayList<>(map.size());
        for (int i = 0, level = minLevel; i < map.size(); i++) {
            List<Integer> ent = map.get(level++);
            Collections.sort(ent);
            result.add(ent);
        }
        return result;
    }

    /**
     * 递归遍历整个树
     * 
     * @param root  当前根节点
     * @param map   记录当前层的节点
     * @param level 当前层（从左往右，初始树根是0，左子树-1， 右子树+1）
     * @return
     */
    private int verticalTraversal0(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return level;
        }

        List<Integer> list = map.getOrDefault(level, new LinkedList<Integer>());
        list.add(root.val);
        map.put(level, list);

        int leftLevel = root.left == null ? level : verticalTraversal0(root.left, map, level - 1);
        int rightLevel = root.right == null ? level : verticalTraversal0(root.right, map, level + 1);
        return Math.min(leftLevel, rightLevel);
    }
}

package org.lj.ds.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TreeNode
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

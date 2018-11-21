package com.gemini.cloud.leetcode.interview;

/**
 * 阿里面试题2
 *
 * 判断两棵树是否相等
 */
public class TwoTreesEquals {

  public boolean equals(TreeNode t1, TreeNode t2) {

    boolean leftEq = true;
    boolean rightEq = true;

    if (t1 == null || t2 == null){
      //两个都为空时
      return true;
    } else if (( t1 == null && t2 != null) || (t2 == null && t1 != null)) {
      //两个有一个为空，一个不为空时
      return false;
    } else if ( t1.val != t2.val) {
      //两个节点值不相等时
      return false;
    }

    // 递归处理左右子树
    leftEq = equals(t1.left, t2.left);
    rightEq = equals(t1.right, t2.right);

    return leftEq && rightEq;

  }

  class TreeNode {

    int val;

    TreeNode left;
    TreeNode right;
    TreeNode(int val){
      this.val = val;
    }
  }

}


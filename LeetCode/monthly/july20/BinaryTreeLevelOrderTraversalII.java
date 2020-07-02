import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import sun.swing.BakedArrayList;

public class BinaryTreeLevelOrderTraversalII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<Integer>();

        while (queue.size() > 1 || (queue.size() == 1 && queue.peek() != null)) {
            TreeNode node = queue.poll();

            if (node == null) {
                ans.add(list);
                queue.add(null);
                list = new ArrayList<>();
                continue;
            }

            list.add(node.val);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        ans.add(list);

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        List<List<Integer>> ans = new BinaryTreeLevelOrderTraversalII().levelOrderBottom(t1);
    }
}
import java.util.*;
import java.lang.*;

class TreeNode {
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}

public class inorderTraversal {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        
        inorderTraversal a = new inorderTraversal();
        a.inorder(root);
    }

    public void inorder(TreeNode root){
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
}

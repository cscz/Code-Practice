import java.lang.*;
import java.util.*;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class preorderTraversal {
	public static void main(String args[]) {
        	TreeNode root = new TreeNode(3);
        	root.left = new TreeNode(1);
        	root.right = new TreeNode(5);
        	root.right.left = new TreeNode(4);
        	root.left.left = new TreeNode(0);
        	root.left.right = new TreeNode(2);

		preorderTraversal a = new preorderTraversal();
		a.preorder(root);

	}

	public void preorder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.println(root.val);
			if(root.right != null) {
				stack.push(root.right);
			}
			if(root.left != null) {
				stack.push(root.left);
			}
		}	
	}
}

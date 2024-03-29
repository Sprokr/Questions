public class ValidateBST
{
	public boolean isSubTreeLesser(TreeNode root, int value)
	{
		if(root==null)
			return true;
		else
		{
			if(root.val<value &&isSubTreeLesser(root.left, value) && isSubTreeLesser(root.right, value))
				return true;
		}
		return false;
	}

	public boolean isSubTreeGreater(TreeNode root, int value)
	{
		if(root==null)
			return true;
		else
		{
			if(root.val>value && isSubTreeGreater(root.left, value) && isSubTreeGreater(root.right, value))
				return true;
		}
		return false;
	}

	public boolean isValidBST(TreeNode root)
	{
		if(root==null)
			return true;
		else
		{
			if(isSubTreeLesser(root.left, root.val)
				&& isSubTreeGreater(root.right, root.val)
				&& isValidBST(root.left)
				&& isValidBST(root.right))
					return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		ValidateBST v = new ValidateBST();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		//root.right = new TreeNode(15);
		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(6);
		//root.right.left= new TreeNode(13);
		//root.right.right = new TreeNode(20);
		// root.left.left.left = new TreeNode(7);
		// root.left.left.right = new TreeNode(8);
		// root.left.right.left = new TreeNode(9);
		// root.left.right.right = new TreeNode(10);
		// root.left.right.right.left = new TreeNode(13);
		// root.left.right.right.right = new TreeNode(14);
		// root.right.right.left = new TreeNode(11);
		// root.right.right.right = new TreeNode(12);
		// root.right.right.left.right = new TreeNode(15);
		// root.right.right.right.right = new TreeNode(16);
		System.out.println(v.isValidBST(root));
	}
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
	{
		val = x;
		left = null;
		right = null;
	}
}

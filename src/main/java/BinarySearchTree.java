
public class BinarySearchTree {
	//Class for Nodes of the tree
	class Nodes
	{
		String str;
		Nodes right;
		Nodes left;
		
		public Nodes( String s)
		{
			str=s;
			left=null;
			right=null;
		}
	}
	
	//Binary Search Tree Root
	//Member Variable of BinarySearchTree Class
	Nodes root;
	
	public BinarySearchTree()
	{
		root=null;
	}
	//Input at roots
	public void setroot(String str)
	{
		//System.out.println("Working Fine "+ str);
		root=insert(root,str);
	}
	public Nodes insert(Nodes root, String str)
	{
		//System.out.println("Made it this far"+ str);
		if(root==null)
		{
			root=new Nodes(str);
			return root;
		}
		if(str.length()<=root.str.length())
		{
			root.left=insert(root.left,str);
			//System.out.println(root.left);
		}
		else if (str.length()>root.str.length())
		{
			root.right=insert(root.right,str);
		//	System.out.println(root.right);
			//System.out.println("Ouch");
		}
		return root;
	}
	//Display Function
	void display(Nodes root) {
		traversal(root);
	}
	void traversal(Nodes root)
	{
		if(root!=null)
		{
			display(root.left);
			System.out.println(root.str);
			display(root.right);
		}
	}

}



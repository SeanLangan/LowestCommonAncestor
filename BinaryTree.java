class Node{
	String name;
	Node left;
	Node right;
	public Node(String name) {
		this.name=name;
		left=right=null;
	}
}
public class BinaryTree{
	//Root of the Binary Tree
    Node root;
 
    Node findLCA(String n1, String n2)
    {
        return findLCA(root, n1, n2);
    }
 
    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    Node findLCA(Node node, String n1, String n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.name == n1 || node.name == n2)
            return node;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("Amber");
        tree.root.left = new Node("Brad");
        tree.root.right = new Node("Chad");
        tree.root.left.left = new Node("Mike");
        tree.root.left.right = new Node("James");
        tree.root.right.left = new Node("Laura");
        tree.root.right.right = new Node("Jack");
        System.out.println("LCA(Mike,James) = " + tree.findLCA("Brad","Chad"));
        
    }
}

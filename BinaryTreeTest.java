import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testEmptyLcaTree() {
		BinaryTree tree= new BinaryTree();
		assertEquals("Test Lowest common ancestor of an empty tree",null,tree.findLCA(0,0));
	}
	
	@Test
	public void testOneNodeLcaTree()
	{
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		assertEquals("Test Lowest common ancestor of a one node tree",1,tree.findLCA(1,0).name);
	}
	
	@Test 
	public void testMultiNodeTree() {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);

		assertEquals("Test Lowest common ancestor of a 1 and 10",1,tree.findLCA(1,10).name);
		assertEquals("Test Lowest common ancestor of a 9 and 5",2,tree.findLCA(9,5).name);
		assertEquals("Test Lowest common ancestor of a 3 and 7",3,tree.findLCA(3,7).name);
		assertEquals("Test Lowest common ancestor of a 8 and 4",4,tree.findLCA(8,4).name);

	}
	
	@Test
	public void testmissingLcaNode() {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		assertEquals("Test Lowest Common Ancestor of 1 and 8383838",1,tree.findLCA(1,8383838).name);
		
	}
	@Test 
	public void testEventree() {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals("Test Lowest Common Ancestor of 1 and 2",1,tree.findLCA(1,2).name);
		assertEquals("Test Lowest Common Ancestor of 3 and 4",1,tree.findLCA(3,4).name);


	}
	@Test 
	public void testUnEventree() {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		assertEquals("Test Lowest Common Ancestor of 1 and 2",1,tree.findLCA(1,2).name);
		assertEquals("Test Lowest Common Ancestor of 3 and 1",1,tree.findLCA(3,1).name);


	}
	@Test 
	public void testLookingForSameNode() {
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals("Test Lowest Common Ancestor of 4 and 4",4,tree.findLCA(4,4).name);
	}
}

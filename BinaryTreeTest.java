import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testEmpty() {
		BinaryTree tree = new BinaryTree();
		assertEquals(-1,tree.LCA(0,0));
	}
	
	@Test
	public void testSingle()
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		assertEquals(-1,tree.LCA(1,0));
	}
	
	@Test 
	public void testNormalCase() {
		BinaryTree tree = new BinaryTree();
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

		assertEquals(1,tree.LCA(1,10));
		assertEquals(2,tree.LCA(9,5));
		assertEquals(3,tree.LCA(3,7));
		assertEquals(4,tree.LCA(8,4));

	}
	
	@Test 
	public void testEven() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals(1,tree.LCA(1,2));
		assertEquals(1,tree.LCA(3,4));


	}
	
	
	
	@Test 
	public void testSameName() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals(4,tree.LCA(4,4));


	}
	@Test
	public void testMissing() {
		BinaryTree tree = new BinaryTree();
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
		assertEquals(-1,tree.LCA(1,8383838));
		
	}
	@Test 
	public void testOdd() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		assertEquals(1,tree.LCA(1,2));
		assertEquals(1,tree.LCA(3,1));


	}
	@Test 
	public void testDAG() {
		
		BinaryTree theGraph=new BinaryTree();
		Node root= new Node(1);
		Node nodeTwo= new Node(2);
		Node nodeThree = new Node(3);
		Node nodeFour = new Node(4);
		Node nodeFive= new Node(5);
		Node nodeSix = new Node(6);
		Node nodeSeven = new Node(7);
		
		
		theGraph.addToGraph(root);
		theGraph.addToGraph(nodeTwo);
		theGraph.addToGraph(nodeThree);
		theGraph.addToGraph(nodeFour);
		theGraph.addToGraph(nodeFive);
		theGraph.addToGraph(nodeSix);
		theGraph.addToGraph(nodeSeven);

		
		theGraph.addRelations(root, nodeTwo);
		theGraph.addRelations(root, nodeThree);
		theGraph.addRelations(nodeTwo, nodeFour);
		theGraph.addRelations(nodeThree, nodeFour);
		theGraph.addRelations(nodeFour, nodeFive);
		theGraph.addRelations(nodeFour, nodeSix);
		theGraph.addRelations(nodeSix, nodeSeven);
		theGraph.addRelations(root, nodeSeven);


		assertEquals(1, theGraph.LCA_DAG(root, nodeTwo, nodeThree ));
		assertEquals(1, theGraph.LCA_DAG(root, root, root ));
		assertEquals(4, theGraph.LCA_DAG(root, nodeFive, nodeSix ));
		assertEquals(3, theGraph.LCA_DAG(root, nodeFour, nodeThree ));
		assertEquals(1, theGraph.LCA_DAG(root, root, nodeSeven ));





	}
	@Test
	public void testEmptyDAG() {
		BinaryTree theGraph = new BinaryTree();
		assertEquals(-1,theGraph.LCA(0,0));
	}
	public void oneNodeDAG() {
		BinaryTree theGraph = new BinaryTree();
		Node root= new Node(1);
		theGraph.addToGraph(root);
		assertEquals(1, theGraph.LCA_DAG(root, root, root ));
		
	}
	
}

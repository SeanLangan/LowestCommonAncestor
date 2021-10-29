import java.util.ArrayList;
import java.util.List;

class Node {
	ArrayList<Node> relations;
	int name;
	Node left, right;
	
	Node(int name) {
		this.name = name;
		left = right = null;
		relations = null;
	}
}

public class BinaryTree {

	Node root;
	List<Integer> firstNameList = new ArrayList<>();
	List<Integer> secondNameList = new ArrayList<>();

	int LCA(int node1, int node2) {
		firstNameList.clear();
		secondNameList.clear();
		return findLCA(root, node1, node2);
	}

	private int findLCA(Node root, int node1, int node2) {
		if(!findPath(root, node1, firstNameList)|| !findPath(root, node2,secondNameList)) {
			return -1;
		}
		int i;
		for(i=0; i < firstNameList.size() && i < secondNameList.size(); i++) {
			if(!firstNameList.get(i).equals(secondNameList.get(i))) {
				break;
			}
		}
		return firstNameList.get(i-1);
		
	}
	
	protected int LCA_DAG(Node root, Node nodeOne, Node nodeTwo) {
		if(nodeOne !=null && nodeTwo != null) {
			if(nodeOne.relations !=null && nodeTwo.relations != null) {
				for(int i = 0; i <nodeTwo.relations.size();i++) {
					for (int j = 0;j<nodeOne.relations.size();j++) {
						if(nodeTwo.relations.get(i) == nodeOne.relations.get(j)) {
							return nodeTwo.relations.get(i).name;
						}
					}
				}
			}else {
				return -1;
			}
		}
		return -1;
	}
	private boolean findPath(Node root, int num, List<Integer> path) {
		if (root == null) {
			return false;	
		} else {
			path.add(root.name);
			if (root.name == num) {
				return true;
			}
			if (root.left != null && findPath(root.left, num, path)) {
				return true;
			}
			if (root.right != null && findPath(root.right, num, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}
	}
	public void addToGraph(Node nodeOne) {
		nodeOne.relations = new ArrayList<Node>();
		nodeOne.relations.add(nodeOne);
		
	}
	public void addRelations(Node nodeOne, Node nodeTwo) {
		int i;
		for(i=0; i<nodeOne.relations.size();i++) {
			if(!nodeTwo.relations.contains(nodeOne.relations.get(i))) {
				nodeTwo.relations.add(nodeOne.relations.get(i));
			}
			
		}
	}

}

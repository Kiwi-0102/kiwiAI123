package lab2_k21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFSGraphSearchAIgo implements ISearchAlgo{
	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node child : children) {
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node startNode = findNode(root, start);
        if (startNode != null) {
            return execute(startNode, goal);
        }
        
        return null;  // Start node was not found in the tree/graph.
    }

    // Helper method to find a node by its label.
    private Node findNode(Node root, String label) {
        if (root.getLabel().equals(label)) {
            return root;
        }
        for (Node child : root.getChildrenNodes()) {
            Node result = findNode(child, label);
            if (result != null) {
                return result;
            }
        }
		return null;
	}

}

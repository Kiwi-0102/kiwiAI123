package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BFSGraphSearchAIgo implements ISearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
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
		return null; // Return null if the goal is not found.
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if(root.getLabel().equals(start)) {
			return root;
		}
		for (Node child: root.getChildrenNodes()) {
			Node result = execute(child, start, goal);
			if(result!= null) {
				return result;
			}
		}
		return null;
	}

}

package student;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node tree, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> explored = new HashSet<Node>();
		frontier.offer(tree);

		while (!frontier.isEmpty()) {
			Node curr = frontier.poll();
			explored.add(curr);
			if (curr.getLabel().equals(goal))
				return curr;

			List<Edge> childrens = curr.getChildren();
			for (Edge e : childrens) {
				Node child = e.getEnd();
				if (!explored.contains(child))
					if (!frontier.contains(child)) {
						child.setParent(curr);
						child.setG(curr.getG() + e.getWeight());
						frontier.offer(child);
					} else {
						double newG = curr.getG() + e.getWeight();
						if (newG < child.getG()) {
							child.setParent(curr);
							child.setG(newG);
						}
					}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> explored = new HashSet<Node>();
		boolean started = false;
		frontier.offer(tree);

		while (!frontier.isEmpty()) {
			Node curr = frontier.poll();
			explored.add(curr);
			if (curr.getLabel().equals(goal))
				if (started)
					return curr;
				else
					return null;

			for (Edge e : curr.getChildren()) {
				Node child = e.getEnd();
				if (!explored.contains(child))
					if (!frontier.contains(child)) {
						if (child.getLabel().equals(start)) {
							started = true;
							child.setParent(null);
							child.setG(0);
							frontier.clear();
							frontier.offer(child);
							break;
						}
						child.setParent(curr);
						child.setG(curr.getG() + e.getWeight());
						frontier.offer(child);
					} else {
						double newG = curr.getG() + e.getWeight();
						if (newG < child.getG()) {
							child.setParent(curr);
							child.setG(newG);
						}
					}
			}
		}
		return null;
	}

}

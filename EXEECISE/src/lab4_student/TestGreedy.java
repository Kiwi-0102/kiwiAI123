package lab4_student;

public class TestGreedy {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);

		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);

		IInformedSearchAlgo greedy = new GreedyBestFirstSearchAlgo1();
		Node res = greedy.execute(s, g.getLabel());
		System.out.println("Greedy from S to G:  "+ NodeUtils.printPath(res));
		
		Node res1 = greedy.execute(s, c.getLabel(), g.getLabel());
		System.out.println("Greedy from C to G:  "+ NodeUtils.printPath(res1));
		
	}
}

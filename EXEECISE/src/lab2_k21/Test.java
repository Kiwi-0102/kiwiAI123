package lab2_k21;

import java.security.Principal;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BFSGraphSearchAIgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println("BFS:	" + NodeUtils.printPath(result));
		ISearchAlgo algo2 = new DFSGraphSearchAIgo();
		Node result2 = algo2.execute(nodeS, "G");
		System.out.println("DFS:	" + NodeUtils.printPath(result2));
		ISearchAlgo algo3 = new UniformCostSearchAlgo();
		Node result3 = algo3.execute(nodeS, "G");
		System.out.println("UCS:	  "+ NodeUtils.printPath(result3));
		
		UniformCostSearchAlgo DLS = new UniformCostSearchAlgo();
		Node nodeSG = DLS.execute(nodeS, "GOAL");
		NodeUtils.print(nodeSG);
		Node nodeEG = DLS.execute(nodeS, "e", "GOAL");
		NodeUtils.print(nodeEG);
	}
}

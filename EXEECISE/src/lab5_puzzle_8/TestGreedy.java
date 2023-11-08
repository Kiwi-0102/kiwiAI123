package lab5_puzzle_8;

import lab5_puzzle_8.GreedyBestFirstSearch;

public class TestGreedy {
	public static void main(String[] args) {
		Puzzle p = new Puzzle(true);
		p.readInput("./txt/PuzzleMap.txt", "./txt/PuzzleGoalState.txt");
		GreedyBestFirstSearch greedy = new GreedyBestFirstSearch();

		System.out.println("Processing with h1...");
		Node re = greedy.execute(p);
		PuzzleUtils.printPath(re);
		StringBuilder stb = new StringBuilder(
				"\nUsed h1: G = " + re.getG() + ", WHILE_LOOP = " + GreedyBestFirstSearch.WHILE_LOOP);

		p.setUseH1(false);
		GreedyBestFirstSearch.WHILE_LOOP = 0;
		System.out.println("\nProcessing with h2...");
		re = greedy.execute(p);
		PuzzleUtils.printPath(re);

		System.out.println(
				stb.append("\nUsed h2: G = " + re.getG() + ", WHILE_LOOP = " + GreedyBestFirstSearch.WHILE_LOOP)
						.toString());
	}
}

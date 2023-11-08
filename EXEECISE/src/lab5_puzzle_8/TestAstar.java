package lab5_puzzle_8;

import java.util.Arrays;
import java.util.List;

public class TestAstar {

	public static void main(String[] args) {
		Puzzle p = new Puzzle(true);
		p.readInput("./txt/PuzzleMap.txt", "./txt/PuzzleGoalState.txt");
		AStarSearch aStar = new AStarSearch();

		System.out.println("Processing with h1...");
		Node re = aStar.execute(p);
		PuzzleUtils.printPath(re);
		StringBuilder stb = new StringBuilder("\nUsed h1: G = " + re.getG() +
				", WHILE_LOOP = " + AStarSearch.WHILE_LOOP);

		p.setUseH1(false);
		AStarSearch.WHILE_LOOP = 0;
		System.out.println("\nProcessing with h2...");
		re = aStar.execute(p);
		PuzzleUtils.printPath(re);

		System.out.println(stb.append("\nUsed h2: G = " + re.getG() +
				", WHILE_LOOP = " + AStarSearch.WHILE_LOOP).toString());
	}

}

package lab5_puzzle_8;

import lab5_puzzle_8.AStarSearch;
import lab5_puzzle_8.BFS;
import lab5_puzzle_8.DFS;
import lab5_puzzle_8.GreedyBestFirstSearch;
import lab5_puzzle_8.Node;
import lab5_puzzle_8.Puzzle;

public class testAll {
	private static StringBuilder stb = new StringBuilder();

	public static void main(String[] args) {
		Puzzle p = new Puzzle(true);
		p.readInput("./txt/MapTestAll.txt", "./txt/PuzzleGoalState.txt");
		GreedyBestFirstSearch GreedyBestFirstSearch = new GreedyBestFirstSearch();
		AStarSearch AStarSearch = new AStarSearch();
		BFS bfs = new BFS();
		DFS dfs = new DFS();
		Node re;

		System.out.println("GreedyBestFirstSearch");
		re = GreedyBestFirstSearch.execute(p);
		print(re, "GreedyBestFirstSearch", 1);
		p.setUseH1(false);
		re = GreedyBestFirstSearch.execute(p);
		print(re, "GreedyBestFirstSearch", 2);

		System.out.println("AStarSearch");
		p.setUseH1(true);
		re = AStarSearch.execute(p);
		print(re, "AStarSearch", 1);
		p.setUseH1(false);
		re = AStarSearch.execute(p);
		print(re, "AStarSearch", 2);

		System.out.println("BFS tree search approach");
		p.setUseH1(true);
		re = bfs.execute(p);
		print(re, "bfs", 1);
		p.setUseH1(false);
		re = bfs.execute(p);
		print(re, "bfs", 2);


		System.out.println("DFS tree search approach");
//		p.setUseH1(true);
//		re = dfs.execute(p);
//		print(re, "dfs", 1);
//		p.setUseH1(false);
//		re = dfs.execute(p);
//		print(re, "dfs", 2);
	}

	public static void print(Node re, String algo, int n) {
		int loop = 0;
		switch (algo) {
		case "GreedyBestFirstSearch":
			loop = GreedyBestFirstSearch.WHILE_LOOP;
			break;
		case "AStarSearch":
			loop = AStarSearch.WHILE_LOOP;
			break;
		case "bfs":
			loop = BFS.WHILE_LOOP;
			break;
		case "dfs":
			loop = DFS.WHILE_LOOP;
			break;
		}
		stb.append("\nUsed h" + n + ": G = " + re.getG() + ", WHILE_LOOP = " + loop);
		if (n == 2) {
			System.out.println(stb.toString());
			System.out.println("\n———————————————————————————————————");
			stb.setLength(0);
		}

		switch (algo) {
		case "GreedyBestFirstSearch":
			GreedyBestFirstSearch.WHILE_LOOP = 0;
			break;
		case "AStarSearch":
			AStarSearch.WHILE_LOOP = 0;
			break;
		case "bfs":
			BFS.WHILE_LOOP = 0;
			break;
		case "dfs":
			DFS.WHILE_LOOP = 0;
			break;
		}
	}

}

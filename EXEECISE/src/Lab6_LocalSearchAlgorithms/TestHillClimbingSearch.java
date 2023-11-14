package Lab6_LocalSearchAlgorithms;

public class TestHillClimbingSearch {

	public static void main(String[] args) {
		Node initialState = new Node();
		initialState.displayBoard();
		System.out.println("H = " + initialState.getH());
		HillClimbingSearch hcs = new HillClimbingSearch();
		System.out.println("-----------------------------");

		Node re = hcs.execute(initialState);
		System.out.println("H = " + re.getH());
		hcs.printStepClimbed();
		re.displayBoard();
		System.out.println("-----------------------------");
		
		System.out.println("Processing execute with random restart...");
		re = hcs.executeWithRandomRestart(initialState);
		System.out.println("H = " + re.getH());
		re.displayBoard();
		hcs.printStepClimbed();
		
	}

}

package Lab7_GeneticAlgorithms;

public class TestGA {
	public static void main(String[] args) {
		GA_NQueenAlgo GA = new GA_NQueenAlgo();
		Node re = GA.execute();
		System.out.println("H: "+ re.getH());
		re.displayBoard();
	}
}

package Lab6_LocalSearchAlgorithms;

public class TestSimulatedAnnealing {

	public static void main(String[] args) {
		Node initialState = new Node();
		initialState.displayBoard();
		System.out.println("H = " + initialState.getH());
		System.out.println("��������������������");

		Node re = null;
		try {
			re = SimulatedAnnealing.execute(initialState, 1000, 0.995);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("H = " + re.getH());
		re.displayBoard();

	}

}
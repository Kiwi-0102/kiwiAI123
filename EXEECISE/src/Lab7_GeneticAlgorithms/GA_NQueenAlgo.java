package Lab7_GeneticAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		int k = 0;
		initPopulation();
		while (k++ < MAX_ITERATIONS) {
			List<Node> newpopulation = new ArrayList<Node>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByTournamentSelection(5);
				Node child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE)
					mutate(child);
				if (child.getH() == 0) {

					System.out.println("H: " + child.getH());
					return child;
				}
				newpopulation.add(child);
			}
			population = newpopulation;
		}

		Collections.sort(population);
		System.out.println(population.get(0).getH());
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		node.getState()[rd.nextInt(Node.N)].setRow(rd.nextInt(Node.N));

	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
		Node re = new Node();
		re.generateBoard();
		for (int i = 0; i < c; i++) {
			re.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			re.setRow(i, y.getRow(i));
		}
		return re;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		List<Node> listParent = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			listParent.add(getParentByRandomSelection());
		}
		Collections.sort(listParent);
		return listParent.get(0);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		Node parent = population.get(rd.nextInt(POP_SIZE));
		return parent;
	}


}

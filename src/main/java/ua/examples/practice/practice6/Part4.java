package ua.examples.practice.practice6;

public class Part4 {
	
	public static void main(String[] args) {

		Graph graph = new Graph(10);
		graph.addLimb(1, 10);
		graph.addLimb(2, 5);
		graph.addLimb(1, 3);
		graph.addLimb(2, 6);
		graph.addLimb(2, 10);
		graph.addLimb(2, 3);
		graph.addLimb(-2, 3);
		graph.addLimb(-2, 5);
		graph.addLimb(20, 30);
		graph.addLimb(23, 325);
		graph.addLimb(33, 333);
		System.out.println(graph.limbs);
		graph.addLimb(5, -2);
		graph.removeLimb(325, 23);
		System.out.println(graph.limbs);
	}
}

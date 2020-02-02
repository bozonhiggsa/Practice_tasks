package ua.examples.practice.practice6;

public class Part5 {
	
	public static void main(String[] args) {

		Tree<Integer> tree = new Tree<>();
		
		System.out.println(tree.add(3));
		System.out.println(tree.add(3));
				
		System.out.println("~~~~~~~");
		tree.add(new Integer[] {1, 2, 5, 4, 6, 0});
		tree.print();

		/*System.out.println(tree.add(6));
		System.out.println(tree.add(6));

		System.out.println("~~~~~~~");
		tree.add(new Integer[] {1, 0, 5, 8, 7, 9, 3, 2, 4});
		tree.print();*/

		/*System.out.println(tree.add(3));
		System.out.println(tree.add(3));

		System.out.println("~~~~~~~");
		tree.add(new Integer[] {1, 8, 0, 2, 7, 9, 5, 6, 4});
		tree.print();*/
				
		System.out.println("~~~~~~~");
		System.out.println(tree.remove(3));
		System.out.println(tree.remove(3));

		System.out.println("~~~~~~~");
		tree.print();
	}
}

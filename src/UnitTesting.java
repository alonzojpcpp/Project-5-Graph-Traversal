import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTesting {

	@Test
	public void testGraph1() throws EmptyQueueException {
		Graph<Character> testGraph1 = new Graph<>(9);

		testGraph1.addEdge(0, 3);
		testGraph1.addEdge(3, 5);
		testGraph1.addEdge(5, 6);
		testGraph1.addEdge(6, 7);
		testGraph1.addEdge(7, 4);
		testGraph1.addEdge(4, 2);
		testGraph1.addEdge(2, 1);
		testGraph1.addEdge(1, 0);


		
		testGraph1.setLabel(0, 'A');
		testGraph1.setLabel(1, 'B');
		testGraph1.setLabel(2, 'C');
		testGraph1.setLabel(3, 'D');
		testGraph1.setLabel(4, 'E');
		testGraph1.setLabel(5, 'F');
		testGraph1.setLabel(6, 'G');
		testGraph1.setLabel(7, 'H');
		
		System.out.println("A -> D -> F");
		System.out.println("^         |");
		System.out.println("|         v");
		System.out.println("B         G");
		System.out.println("^         |");
		System.out.println("|         v");
		System.out.println("C <- E <- H");
		
		System.out.print("BFT From Code:  ");
		System.out.println(testGraph1.breadthFirstTraversal(0));
		System.out.println("BFT From Graph: A D F G H E C B ");
		assertEquals(testGraph1.breadthFirstTraversal(0), "A D F G H E C B ");

		System.out.println("");

		
		System.out.print("DFT From Code:  ");
		System.out.println(testGraph1.depthFirstTraversal(0));
		System.out.println("DFT From Graph: A D F G H E C B ");
		assertEquals(testGraph1.depthFirstTraversal(0), "A D F G H E C B ");



	}

}

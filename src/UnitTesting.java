import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class UnitTesting {

	@Test
	public void testGraph1() throws EmptyQueueException {
		Graph<Character> testGraph1 = new Graph<>(8);
		System.out.println("--------------------------------------------------");
		System.out.println("Graph that loops:");

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
		
		System.out.println("");

		System.out.println("- - - - - Starting at node A - - - - - ");

		System.out.println("BFT:");
		String expected = testGraph1.breadthFirstTraversal(0);
		String actual = "A D F G H E C B ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + actual);
		assertEquals(expected, actual);
		
		System.out.println("DFT:");
		expected = testGraph1.depthFirstTraversal(0);
		actual = "A D F G H E C B ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + actual);
		assertEquals(expected, actual);
		
	}

	
	  @Test public void testGraph2() throws EmptyQueueException { 
	  Graph<Character> testGraph2 = new Graph<>(9);
	  System.out.println("--------------------------------------------------");
	  System.out.println("Graph with dead ends:");

	  testGraph2.addEdge(0, 1); 
	  testGraph2.addEdge(0, 3);
	  testGraph2.addEdge(1, 4);
	  testGraph2.addEdge(3, 4); 
	  testGraph2.addEdge(4, 5); 
	  testGraph2.addEdge(4, 7);
	  testGraph2.addEdge(7, 6); 
	  testGraph2.addEdge(7, 8); 
	  testGraph2.addEdge(5, 2);
	  testGraph2.addEdge(5, 8);
	  
	  
	  testGraph2.setLabel(0, 'A'); 
	  testGraph2.setLabel(1, 'B');
	  testGraph2.setLabel(2, 'C'); 
	  testGraph2.setLabel(3, 'D');
	  testGraph2.setLabel(4, 'E'); 
	  testGraph2.setLabel(5, 'F');
	  testGraph2.setLabel(6, 'G'); 
	  testGraph2.setLabel(7, 'H');
	  testGraph2.setLabel(8, 'I');
	  
	  System.out.println("A -> D    G");
	  System.out.println("|    |    ^");
	  System.out.println("v    v    |"); 
	  System.out.println("B -> E -> H");
	  System.out.println("     |    |"); 
	  System.out.println("     v    v");
	  System.out.println("C <- F -> I");
	  
		System.out.println("");
		
		System.out.println("- - - - - Starting at node A - - - - - ");

		System.out.println("BFT:");
		String expected = testGraph2.breadthFirstTraversal(0);
		String actual = "A B D E F H C I G ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + actual);
		assertEquals(expected, actual);

		System.out.println("DFT:");
		expected = testGraph2.depthFirstTraversal(0);
		actual = "A B E F C I H G D ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + actual);
		assertEquals(expected, actual);
	  }
	 
	@Test
	public void testGraph3() throws EmptyQueueException {
		  System.out.println("--------------------------------------------------");
		  System.out.println("Graph with a node that isn't pointed to:");

		  Graph<Character> testGraph3 = new Graph<>(9);
		  testGraph3.addEdge(0, 1); 
		  testGraph3.addEdge(0, 3);
		  testGraph3.addEdge(1, 2);
		  testGraph3.addEdge(2, 5); 
		  testGraph3.addEdge(5, 8); 
		  testGraph3.addEdge(8, 7);
		  testGraph3.addEdge(7, 4); 
		  testGraph3.addEdge(4, 7);   
		  
		  testGraph3.setLabel(0, 'A'); 
		  testGraph3.setLabel(1, 'B');
		  testGraph3.setLabel(2, 'C'); 
		  testGraph3.setLabel(3, 'D');
		  testGraph3.setLabel(4, 'E'); 
		  testGraph3.setLabel(5, 'F');
		  testGraph3.setLabel(6, 'G'); 
		  testGraph3.setLabel(7, 'H');
		  testGraph3.setLabel(8, 'I');
		  
		  System.out.println("A -> D    G");
		  System.out.println("|          ");
		  System.out.println("v          "); 
		  System.out.println("B <- E <- H");
		  System.out.println("|         ^"); 
		  System.out.println("v         |");
		  System.out.println("C -> F -> I");
		  
			System.out.println("");

			System.out.println("- - - - - Starting at node A - - - - - ");

			System.out.println("BFT:");
			String expected = testGraph3.breadthFirstTraversal(0);
			String actual = "A B D C F I H E ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);

			System.out.println("DFT:");
			expected = testGraph3.depthFirstTraversal(0);
			actual = "A B C F I H E D ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);
	}
	
	@Test
	public void testGraph4() throws EmptyQueueException {
		  System.out.println("--------------------------------------------------");
		  System.out.println("\"Random\" Graph");

		  Graph<Character> testGraph4 = new Graph<>(15);
		  testGraph4.addEdge(0, 1);  
		  testGraph4.addEdge(1, 2);
		  testGraph4.addEdge(2, 3);
		  testGraph4.addEdge(3, 4);
		  testGraph4.addEdge(5, 0);
		  testGraph4.addEdge(5, 8);
		  testGraph4.addEdge(6, 1);
		  testGraph4.addEdge(7, 3);
		  testGraph4.addEdge(7, 11);
		  testGraph4.addEdge(8, 9);
		  testGraph4.addEdge(9, 10);
		  testGraph4.addEdge(9, 13);
		  testGraph4.addEdge(10, 11);
		  testGraph4.addEdge(10, 14);
		  testGraph4.addEdge(11, 12);
		  testGraph4.addEdge(13, 14);
		  
		  testGraph4.setLabel(0, 'A'); 
		  testGraph4.setLabel(1, 'B');
		  testGraph4.setLabel(2, 'C'); 
		  testGraph4.setLabel(3, 'D');
		  testGraph4.setLabel(4, 'E'); 
		  testGraph4.setLabel(5, 'F');
		  testGraph4.setLabel(6, 'G'); 
		  testGraph4.setLabel(7, 'H');
		  testGraph4.setLabel(8, 'I');
		  testGraph4.setLabel(9, 'J'); 
		  testGraph4.setLabel(10, 'K');
		  testGraph4.setLabel(11, 'L'); 
		  testGraph4.setLabel(12, 'M');
		  testGraph4.setLabel(13, 'N');
		  testGraph4.setLabel(14, 'O');

		  System.out.println("A <- F -> I");
		  System.out.println("|         |");
		  System.out.println("v         V"); 
		  System.out.println("B <- G    J -> N");
		  System.out.println("|         |    |"); 
		  System.out.println("v         v    v");
		  System.out.println("C         K -> O");
		  System.out.println("|         |"); 
		  System.out.println("v         v");
		  System.out.println("D <- H -> L");
		  System.out.println("|         |"); 
		  System.out.println("v         v");
		  System.out.println("E         M");
		  
			System.out.println("");

			System.out.println("- - - - - Starting at node F - - - - - ");
			System.out.println("BFT:");
			String expected = testGraph4.breadthFirstTraversal(5);
			String actual = "F A I B J C K N D L O E M ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);

			System.out.println("DFT:");
			expected = testGraph4.depthFirstTraversal(5);
			actual = "F A B C D E I J K L M O N ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);
	}
	
	@Test
	public void testGraph5() throws EmptyQueueException {
		Graph<Character> testGraph1 = new Graph<>(1);
		System.out.println("--------------------------------------------------");
		System.out.println("Graph with no nodes:");

		System.out.println("");

		System.out.println("- - - - - Starting at no node - - - - - ");

		System.out.println("BFT:");
		String expected = testGraph1.breadthFirstTraversal(0);
		String actual = null + " ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + null);
		assertEquals(expected, actual);
		
		System.out.println("DFT:");
		expected = testGraph1.depthFirstTraversal(0);
		actual = null + " ";
		System.out.println("Expected:  " + expected);
		System.out.println("Actual:    " + actual);
		assertEquals(expected, actual);
	}
	
	@Test
	
	public void testGraph6() throws EmptyQueueException {
		  System.out.println("--------------------------------------------------");
		  System.out.println("Graph that spirals: ");

		  Graph<Character> testGraph6 = new Graph<>(9);
		  testGraph6.addEdge(4, 1);  
		  testGraph6.addEdge(4, 3);
		  testGraph6.addEdge(4, 5);
		  testGraph6.addEdge(4, 7);
		  testGraph6.addEdge(1, 0);
		  testGraph6.addEdge(1, 2);
		  testGraph6.addEdge(3, 0);
		  testGraph6.addEdge(3, 6);
		  testGraph6.addEdge(7, 6);
		  testGraph6.addEdge(7, 8);
		  testGraph6.addEdge(5, 2);
		  testGraph6.addEdge(5, 8);
		  
		  testGraph6.setLabel(0, 'A'); 
		  testGraph6.setLabel(1, 'B');
		  testGraph6.setLabel(2, 'C'); 
		  testGraph6.setLabel(3, 'D');
		  testGraph6.setLabel(4, 'E'); 
		  testGraph6.setLabel(5, 'F');
		  testGraph6.setLabel(6, 'G'); 
		  testGraph6.setLabel(7, 'H');
		  testGraph6.setLabel(8, 'I');

		  System.out.println("A <- D -> G");
		  System.out.println("^    ^    ^");
		  System.out.println("|    |    |"); 
		  System.out.println("B <- E -> H");
		  System.out.println("|    |    |"); 
		  System.out.println("v    v    v");
		  System.out.println("C <- F -> I");
		  
			System.out.println("");

			System.out.println("- - - - - Starting at node E - - - - - ");
			System.out.println("BFT:");
			String expected = testGraph6.breadthFirstTraversal(4);
			String actual = "E B D F H A C G I ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);

			System.out.println("DFT:");
			expected = testGraph6.depthFirstTraversal(4);
			actual = "E B A C D G F I H ";
			System.out.println("Expected:  " + expected);
			System.out.println("Actual:    " + actual);
			assertEquals(expected, actual);
	}
}

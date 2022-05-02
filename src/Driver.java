public class Driver {

	public static void main(String[] args) throws EmptyQueueException {
		Graph<Character> task1Graph = new Graph<>(9);
		// A B C D E F G H I
		// 0 1 2 3 4 5 6 7 8 
		
		task1Graph.addEdge(0, 1);
		task1Graph.addEdge(0, 3);
		task1Graph.addEdge(0, 4);
		task1Graph.addEdge(1, 4);
		task1Graph.addEdge(3, 6);
		task1Graph.addEdge(4, 5);
		task1Graph.addEdge(4, 7);
		task1Graph.addEdge(6, 7);
		task1Graph.addEdge(5, 2);
		task1Graph.addEdge(5, 7);
		task1Graph.addEdge(7, 8);
		task1Graph.addEdge(2, 1);
		task1Graph.addEdge(8, 5);
		
		task1Graph.setLabel(0, 'A');
		task1Graph.setLabel(1, 'B');
		task1Graph.setLabel(2, 'C');
		task1Graph.setLabel(3, 'D');
		task1Graph.setLabel(4, 'E');
		task1Graph.setLabel(5, 'F');
		task1Graph.setLabel(6, 'G');
		task1Graph.setLabel(7, 'H');
		task1Graph.setLabel(8, 'I');
		
		System.out.println("A B D E G F H C I");
		task1Graph.breadthFirstTraversal(0);
	}
	
	

}

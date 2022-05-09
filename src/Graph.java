
public class Graph<E>
{
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels; // labels[i] contains the label for vertex i  
    private int[] BFTResultArray; // BFTResultArray[i] holds the result of breadth-first traversal
    private int BFTResultArrayCounter = 0;
    private int[] DFTResultArray; // DFTResultArray[i] holds the result of depth-first traversal
    private int DFTResultArrayCounter = 0;

    @SuppressWarnings("unchecked")
	public Graph(int n) {
        edges = new boolean[n][n]; // All values initially false
        labels = (E[]) new Object[n]; // All values initially null
    }
    
    // Accessor method to get the label of a vertex of this Graph 
    public E getLabel(int vertex) {
        return labels[vertex];
    }
    
    // Test whether an edge exists
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }
    
    // Add an edge
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }
    
    // Obtain a list of neighbors of a specified vertex of this Graph
    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }
    
    // Remove an edge
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }
    
    // Change the label of a vertex of this Graph
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }
    
    // Accessor method to determine the number of vertices in this Graph
    public int size() {
        return labels.length;
    }
    
    // ---------- Project 5 Code Starts Here ---------
    
    /** Returns true/false depending on if the BFTResultArray contains a certain element or not
    @return  contain - a boolean that is either true/false based on if the element is in the array or not
    @param  node - the element that is checked against BFTResultArray to see if it's in there */
    public boolean BFTContains(int node) {
    	boolean contain = false;
    	
    	// Iterates through the entire array and checks if the parameter anywhere in the array
    	for (int i = 0; i < BFTResultArray.length; i++) {
    		if(node == BFTResultArray[i]) {
    			contain = true;
    		}
    	}
		return contain;
    }
    
    /** Returns true/false depending on if the DFTResultArray contains a certain element or not
    @return  contain - a boolean that is either true/false based on if the element is in the array or not
    @param  node - the element that is checked against DFTResultArray to see if it's in there */
    public boolean DFTContains(int node) {
    	boolean contain = false;
    	
    	// Iterates through the entire array and checks if the parameter anywhere in the array
    	for (int i = 0; i < DFTResultArray.length; i++) {
    		if(node == DFTResultArray[i]) {
    			contain = true;
    		}
    	}
		return contain;
    }
     
    /** Prints the breadth-first traversal of the given graph starting at node
    @return  resultString - a string that contains the elements from breadth-first traversal
    @param  node - the node to start breadth-first traversal at */
    public String breadthFirstTraversal(int node) throws EmptyQueueException {
    	
    	int tempElement = 0;
    	int tempElement2 = 0;
    	int[] tempArray;
    	String resultString = "";
    	
    	// Initializes BFTResultArray with the number of nodes in the graph
    	BFTResultArray = new int[labels.length]; 

    	// Initializes all elements in BFTResultArray as -1
    	for(int i = 0; i < BFTResultArray.length; i++ ) {
    		BFTResultArray[i] = -1;
    	}
    	
		LinkedQueue<Integer> vertexQueue = new LinkedQueue<>();
		// Enqueues the first inputed node
		vertexQueue.enqueue(node);
		
		// Goes through every element in the graph and adds it to the result if it's not there
		while(!vertexQueue.isEmpty()) {
			
			// Gets top vertex and finds it's neighbors
			tempElement = vertexQueue.dequeue();
			tempArray = this.neighbors(tempElement);
			
			// If not in resultArray, add it
			if(!this.BFTContains(tempElement)) {
				BFTResultArray[BFTResultArrayCounter] = tempElement;
				BFTResultArrayCounter++;
			}
			
			// Adds the next element to the queue if it has not been added to resultArray
			for(int j = 0; j < tempArray.length; j++) {
				tempElement2 = tempArray[j];
				
				if(!this.BFTContains(tempElement2)) {
					vertexQueue.enqueue(tempArray[j]);
				}
        	}		
		}
		
		// Prints out BFTResultArray
		for(int i = 0; i < BFTResultArray.length; i++) {
			if(!(BFTResultArray[i] == -1)) {
				resultString += this.getLabel(BFTResultArray[i]) + " ";
			}
		}
		return resultString;
		/* - - - - - Previous code that only works with node 0 - - - - -
		 * int tempElement = 0; int tempNode = node; int[] tempArray; int
		 * resultArrayCounter = 0;
		 * 
		 * LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
		 * 
		 * System.out.print(this.getLabel(node) + " ");
		 * 
		 * // Iterates through every node from 0 - 8 numerically for(int i = 0; i <
		 * this.size(); i++) { tempElement = (node + i) % this.size(); tempArray =
		 * this.neighbors(tempElement);
		 * 
		 * // Enqueues all elements from the temporary array that was holding the
		 * neighbors for(int j = 0; j < tempArray.length; j++) {
		 * linkedQueue.enqueue(tempArray[j]); } }
		 * 
		 * // Empties the queue and saves the result into resultArray
		 * while(!linkedQueue.isEmpty()) { tempElement = linkedQueue.dequeue(); tempNode
		 * = tempElement;
		 * 
		 * // If the element in the queue is not in the resultArray, add it
		 * if(!this.contains(tempElement)) { resultArray[resultArrayCounter] =
		 * tempElement; resultArrayCounter++; } }
		 * 
		 * // Prints out the result array for(int i = 0; i < resultArray.length - 1;
		 * i++) { System.out.print(this.getLabel(resultArray[i]) + " "); }
		 */
    }
    
    /** Prints the depth-first traversal of the given graph starting at node
    @return  resultString - a string that contains the elements from depth-first traversal
    @param  node - the node to start depth-first traversal at */
    public String depthFirstTraversal(int node) throws EmptyQueueException {
    	
    	int tempElement = 0;
    	int[] tempArray;
    	String resultString = "";

    	// Initializes DFTResultArray with the number of nodes in the graph
    	DFTResultArray = new int[labels.length]; 

    	// Initializes all elements in BFTResultArray as -1
    	for(int i = 0; i < DFTResultArray.length; i++ ) {
    		DFTResultArray[i] = -1;
    	}
    	
		ResizableArrayStack<Integer> resizableArrayStack = new ResizableArrayStack<>();		
		
		// Pushes the inputed node into the stack
		resizableArrayStack.push(node);
		
		// Continues to iterate through the stack until it's empty
		while(!resizableArrayStack.isEmpty()) {

			// Sets tempElement to the top of the stack and tempArray to the neighbors
			tempElement = resizableArrayStack.peek();
			tempArray = this.neighbors(tempElement);	
			
			// If tempArray has nothing in it, pop the top of the stack
			if (tempArray.length == 0) {
				resizableArrayStack.pop();
			}

			// If the result array does not contain the element, add it
			if(!this.DFTContains(tempElement)) {
				DFTResultArray[DFTResultArrayCounter] = tempElement;
				DFTResultArrayCounter++;
			}
			
			// Go through all neighbors, if it is not in the array, push into the stack and break, if it is, pop it out of the stack
			for(int j = 0; j < tempArray.length; j++) {
				if(!this.DFTContains(tempArray[j])) {
					resizableArrayStack.push(tempArray[j]);
					break;
				}
				else if (j == tempArray.length - 1){
					resizableArrayStack.pop();
				}
        	}
			
		}
		  
		// Prints out DFTResultArray
		for(int i = 0; i < DFTResultArray.length; i++) {
			if(!(DFTResultArray[i] == -1)) {
				resultString += this.getLabel(DFTResultArray[i]) + " ";
			}
		}
		return resultString;
    }
} 
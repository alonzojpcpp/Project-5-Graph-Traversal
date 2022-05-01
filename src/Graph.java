public class Graph<E>
{
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels; // labels[i] contains the label for vertex i  
    private int[] resultArray = new int[9]; // resultArray[i] holds the result of breadth-first traversal

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
    
    // Returns true/false depending on if the resultArray contains a certain element or not
    public boolean contains(int node) {
    	boolean contain = false;
    	
    	// Iterates through the entire array and checks if the parameter anywhere in the array
    	for (int i = 0; i < resultArray.length; i++) {
    		if(node == resultArray[i]) {
    			contain = true;
    		}
    	}
		return contain;
    }
}
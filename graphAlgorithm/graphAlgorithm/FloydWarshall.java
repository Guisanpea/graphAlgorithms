/**
 * 
 */
package graphAlgorithm;

/**
 * @author Santiago Sánchez Fernández
 *
 */
public class FloydWarshall {
	/**
	 * Runs Floyd-Warshall algorithm on a given graph, and creates distance and
	 * trace graphs
	 * 
	 */
	public void run(CGraph myGraph, CGraph dist, CGraph trace) throws Exception {
		int vertices = myGraph.numVertices();
		int[][] ck = new int[vertices][vertices];
		int[][] tk = new int[vertices][vertices];
		dist.resize(vertices);
		trace.resize(vertices);

		initializeC0(ck, tk, myGraph);
		computeCkAndTk(ck, tk);

		setDistances(dist, ck);
		setTrace(trace, tk);
	}

	private void initializeC0(int[][] c0, int[][] t0, CGraph myGraph) throws Exception {
		int vertices = myGraph.numVertices();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				t0[i][j] = j;
				c0[i][j] = myGraph.get(i, j);
			}
		}
	}

	private void computeCkAndTk(int[][] ck, int[][] tk) {
		int vertices = ck.length;
		
		for (int k = 1; k < vertices; k++) {
			setCk(ck,tk,k);
		}
		
	}

	private void setCk(int[][] ck, int[][] tk, int k) {
		int Infinity = Integer.MAX_VALUE;
		int vertices = ck.length;
		
		for (int i = 0; i < vertices; i++) {
			if(ck[i][k] != Infinity && i != k){
				
				for(int j = 0; j < vertices; j++) {
					if(ck[k][j] != Infinity && j != k && (ck[i][k]+ck[k][j]) < ck[i][j]) {
						ck[i][j] = ck[i][k]+ck[k][j];
						tk[i][j] = k;
					}
				}
			}
		}
	}
	
	private void setDistances(CGraph distances, int[][] ck) throws Exception {
		int vertices = ck.length;

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				distances.set(i, j, ck[i][j]);
			}
		}
	}




	
	private void setTrace(CGraph trace, int[][] tk) throws Exception {
		int vertices = tk.length;
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				trace.set(i, j, tk[i][j]);
			}
		}
	}
}

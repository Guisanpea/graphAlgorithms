/**
 * 
 */
package graphAlgorithm;

/**
 * @author Santiago Sánchez
 *
 */
public class ClosenessCentrality implements NetworkCentrality {

	/* (non-Javadoc)
	 * @see graphAlgorithm.NetworkCentrality#compute(graphAlgorithm.CGraph)
	 */
	@Override
	public double[] compute(CGraph g) throws Exception {
		int Infinity = Integer.MAX_VALUE;
		int vertices = g.numVertices();
		double[] closeness = new double[vertices];
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (i != j && g.get(i, j) < Infinity)
					closeness[i] += g.get(i, j);
			}
			closeness[i] = 1/closeness[i];
		}
		
		return closeness;
	}

	/* (non-Javadoc)
	 * @see graphAlgorithm.NetworkCentrality#getName()
	 */
	@Override
	public String getName() {
		return "Closeness Centrality";
	}

}

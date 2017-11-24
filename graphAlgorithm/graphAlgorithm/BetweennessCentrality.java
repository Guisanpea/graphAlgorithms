/**
 * 
 */
package graphAlgorithm;

/**
 * @author Santiago Sánchez
 *
 */
public class BetweennessCentrality implements NetworkCentrality {

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphAlgorithm.NetworkCentrality#compute(graphAlgorithm.CGraph)
	 */
	@Override
	public double[] compute(CGraph g) throws Exception {
		int vertices = g.numVertices();

		double[] betweenness = new double[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				for (int k = 0; k < vertices; k++) {
					if (g.get(j,k) == i) {
						betweenness[i]++;
					}
				}
				betweenness[i] /= vertices*vertices;
			}
		}
		
		return betweenness;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphAlgorithm.NetworkCentrality#getName()
	 */
	@Override
	public String getName() {
		return "Betweenness Centrality";
	}

}

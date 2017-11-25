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
					if (goesTroughI(g,i,j,k))
						betweenness[i]++;
				}
				betweenness[i] /= vertices*vertices;
			}
		}
		
		return betweenness;
	}

	private boolean goesTroughI(CGraph g, int i, int j, int k) throws Exception{
        int vertex = g.get(j, k);
		boolean goes = (vertex != k) &&
                       ((vertex == i) || (goesTroughI(g,i,j,vertex)));
	    return goes;
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

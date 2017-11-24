/**
 * 
 */
package graphAlgorithm;

/**
 * @author Santiago Sánchez
 *
 */
public class DegreeCentrality implements NetworkCentrality {

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphAlgorithm.NetworkCentrality#compute(graphAlgorithm.CGraph)
	 */
	@Override
	public double[] compute(CGraph g) throws Exception {
		int Infinity = Integer.MAX_VALUE;
		int vertices = g.numVertices();
		double[] degree = new double[vertices];
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (i != j && g.get(i, j) < Infinity)
					degree[i]++;
			}
		}
		
		return degree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphAlgorithm.NetworkCentrality#getName()
	 */
	@Override
	public String getName() {
		return "Degree Centrality";
	}

}

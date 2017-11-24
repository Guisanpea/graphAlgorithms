/**
 * 
 */
package graphAlgorithm;

/**
 * @author Santiago Sánchez
 *
 */
public interface NetworkCentrality {
    /**
     * Returns a vector with the centrality value of each vertex in a graph
     * @throws Exception 
     *
     */
    public abstract double[] compute (CGraph g) throws Exception;

    /**
     * Returns the name of the method used for computing centrality
     *
     */
    public abstract String getName ();
}

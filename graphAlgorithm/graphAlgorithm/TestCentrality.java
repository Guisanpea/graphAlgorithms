/**
 * 
 */
package graphAlgorithm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ccottap
 *
 */
public class TestCentrality {

	/**
	 * @param
	 */
	public static void main(String[] args) throws Exception {
				
		if (args.length < 1) {
    	    System.err.println("You must provide the name of the graph file.");
    	    System.exit(1);
    	}

		final String centralityFilename = "centrality.txt";

		CGraph dist = new CGraph();
		CGraph trace = new CGraph();
		FloydWarshall ashp = new FloydWarshall();
		
		CGraph myGraph = new CGraph();
		myGraph.read(args[0]);
		ashp.run (myGraph, dist, trace);

		DegreeCentrality deg = new DegreeCentrality();
		double[] dc = deg.compute (myGraph);
		ClosenessCentrality clo = new ClosenessCentrality();
		double[] cc = clo.compute (dist);
		BetweennessCentrality bet = new BetweennessCentrality();
		double[] bc = bet.compute (trace);
		
		WriteCentrality (centralityFilename, dc, cc, bc);
		
	}
	
	static void WriteCentrality (String filename, double[] dc, double[] cc, double[] bc) throws IOException {
	    	PrintWriter out = new PrintWriter(new FileWriter(filename));
	    	final int n = dc.length;
	    	for (int i=0; i<n; i++) {
				out.println(i + "\t" + dc[i] + "\t" + cc[i] + "\t" + bc[i]);
	    	}
	    	out.close();
	}
	

}

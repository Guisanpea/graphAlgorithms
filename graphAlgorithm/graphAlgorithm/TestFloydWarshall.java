package graphAlgorithm;

public class TestFloydWarshall {

	public static void main (String[] args) throws Exception {
				
		if (args.length < 1) {
    	    System.err.println("You must provide the name of the graph file.");
    	    System.exit(1);
    	}

		final String distanceFilename = "distance.txt";
		final String traceFilename = "trace.txt";
		CGraph dist = new CGraph();
		CGraph trace = new CGraph();
		FloydWarshall ashp = new FloydWarshall();
		
		CGraph myGraph = new CGraph();
		myGraph.read(args[0]);
		ashp.run (myGraph, dist, trace);
		dist.save(distanceFilename);
		trace.save(traceFilename);
    }
}

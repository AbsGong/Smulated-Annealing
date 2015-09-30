import java.util.ArrayList;


public class Driver {
	public static void main(String[] args){
		Node snellsFarm = new Node("Snell's Farm");
		Node movies = new Node("Movies");
		Node school = new Node("School");
		Node gym = new Node("Gym");
		Node plantersFarm = new Node("Planter's Farm");

		Edge a = new Edge(snellsFarm, movies, 7);
		Edge b = new Edge(movies, school, 10);
		Edge c = new Edge(school, gym, 10);
		Edge d = new Edge(gym, plantersFarm, 8);
		Edge e = new Edge(plantersFarm, snellsFarm, 20);
		Edge f = new Edge(movies, plantersFarm, 12);
		Edge g = new Edge(school, plantersFarm, 14);
		Edge h = new Edge(gym, movies, 15);
		
		Graph graph = new Graph();
		graph.addNode(plantersFarm);
		graph.addNode(gym);
		graph.addNode(school);
		graph.addNode(movies);
		graph.addNode(snellsFarm);
		graph.addEdge(a);
		graph.addEdge(b);
		graph.addEdge(c);
		graph.addEdge(d);
		graph.addEdge(e);
		graph.addEdge(f);
		graph.addEdge(g);
		graph.addEdge(h);
		
		
		SA.searchSA(graph);
		//ArrayList<Edge> testEdge = graph.visit(snellsFarm);
		/*
		for(Edge edge : testEdge){
			System.out.println(edge);
		}
		*.
		*
		*/
		
		//System.out.println(graph.evaluate(testEdge));
		
		//System.out.println(graph);
		/*
		ArrayList<Edge> testEdges = graph.getEdgefrom(movies);
		for (int i = 0; i < testEdges.size(); i++){
			System.out.println(testEdges.get(i));
		}
		*/
		
		/*
		ArrayList<Edge> edgeAL = new ArrayList<Edge>();
		edgeAL.add(a);
		edgeAL.add(b);
		edgeAL.add(c);
		edgeAL.add(d);
		edgeAL.add(e);
		edgeAL.add(f);
		edgeAL.add(g);
		edgeAL.add(h);
		
		for (Edge edge : edgeAL){
			System.out.println(edge);
		}
		
		*/
		
		/*
		ArrayList<Node> nodeAL = new ArrayList<Node>();
		nodeAL.add(snellsFarm);
		nodeAL.add(movies);
		nodeAL.add(school);
		nodeAL.add(gym);
		nodeAL.add(plantersFarm);
		
		for (int i = 0; i < nodeAL.size(); i++){
			System.out.println(nodeAL.get(i));
		}
		*/
	}
}

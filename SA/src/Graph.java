import java.util.ArrayList;
import java.util.Random;
/**
 * Class Name : Graph
 * 
 * Author: Shengqi Gong
 * Date: 9/30/15
 * Description: A Class for object Graph, graph will store edges and nodes, graph has function to operate the
 * graph and node
 * 
 **/

public class Graph {
	private ArrayList<Edge> edges;
	private ArrayList<Node> nodes;
	public Graph(){
		edges = new ArrayList<Edge>();
		nodes = new ArrayList<Node>();
	}
	
	public void addEdge(Edge edge){
		edges.add(edge);
		Edge reversEdge = new Edge(edge.getDest(), edge.getSource(), edge.getWeight());
		edges.add(reversEdge);
	}
	public void addNode(Node node){
		nodes.add(node);
	}
	
	// return edges List from one source node
	public ArrayList<Edge> getEdgefrom(Node source){
		ArrayList<Edge> returnEdge = new ArrayList<Edge>();
		for(Edge edge : edges){
			if (edge.getSource().equals(source) && !edge.getDest().isVisited()){
				returnEdge.add(edge);
			}
		}
		return returnEdge;
	}
	
	// set the destination node be visited
	private void setVisit(Edge edge){
		edge.getDest().setVisited(true);
	}
	
	// get edges from one source node to travel the whole graph
	public ArrayList<Edge> visit(Node source){
		Node start = source;
		start.setVisited(true);
		ArrayList<Edge> returnedges = new ArrayList<Edge>();
		while(true){
			ArrayList<Edge> edges = this.getEdgefrom(start);
			if(edges.size() == 0){
				Edge lastEdge = returnedges.get(returnedges.size() - 1);
				returnedges.add(getEdgeFrom(lastEdge.getDest(), source));
				for(Node node:nodes){
					node.setVisited(false);
				}
				//System.out.print(1);
				return returnedges;
			}
			Random randomGenerator = new Random();
			Edge edge = edges.get(randomGenerator.nextInt(edges.size()));
			returnedges.add(edge);
			edge.getDest().setVisited(true);
			start = edge.getDest();
		}
		
	}
	public Edge getEdgeFrom(Node source, Node dest){
		for (Edge edge: edges){
			if (edge.getSource().equals(source) && edge.getDest().equals(dest))
				return edge;
		}
		return null;
	}
	
	public boolean thereIsfrom(Node source, Node dest){
		for (Edge edge: edges){
			if (edge.getSource().equals(source) && edge.getDest().equals(dest))
				return true;
		}
		return false;
	}
	
	public static double evaluate(ArrayList<Edge> edges){
		double value = 0;
		//int lastIndex = edges.size() -1;
		if (edges.size() != 5){
			return Integer.MAX_VALUE;
		}
		for (Edge edge: edges){
			if (edge == null){
				return Integer.MAX_VALUE;
			}
			value += edge.getWeight();
			
		}
		return value;
	}
	
	public String toString(){
		String result = "";
		for (Edge edge : edges){
			result += edge + "\n";
		}
		return result;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
}

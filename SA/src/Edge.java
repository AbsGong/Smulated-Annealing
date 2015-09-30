
public class Edge {
	
	private Node source;
	private Node dest;
	private double weight;
	
	public Edge(Node source, Node dest, double weight){
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	
	public String toString(){
		String result = "";
		result += "source: " + source;
		result += " destination:" + dest;
		result += " weight: " + weight;
		return result;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getDest() {
		return dest;
	}

	public void setDest(Node dest) {
		this.dest = dest;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


}

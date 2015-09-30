/**
 * Class Name : Node
 * 
 * Author: Shengqi Gong
 * Date: 9/30/15
 * Description: An class for object node, node will be represent the source and destination node of every edge 
 * 
 **/
public class Node{
	
	private String data;
	private boolean visited = false;
	
	public Node(String data){
		this.data = data;
	}
	
	public String toString(){
		return data;
	}
	
	
	public boolean equals(Node node){
		if (node.data.equals(this.data)){
			return true;
		}
		return false;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
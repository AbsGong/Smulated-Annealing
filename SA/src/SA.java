import java.util.ArrayList;
import java.util.Random;

public class SA {
	public static void searchSA(Graph graph){
		Random random = new Random();
		ArrayList<Node> nodes = graph.getNodes();
		double T = Integer.MAX_VALUE;
		while(T>0.00001){
			ArrayList<Edge> currentSolution = graph.visit(nodes.get(random.nextInt(nodes.size())));
			for (int i = 0; i <= 200; i++){
				ArrayList<Edge> nearbySolution = graph.visit(nodes.get(random.nextInt(nodes.size())));
				double EnearbySolution = Graph.evaluate(nearbySolution);
				double EcurrentSolution = Graph.evaluate(currentSolution);
				double E =  EnearbySolution - EcurrentSolution ;
				if (E < 0) {
					//lower engergy state is found
					
					currentSolution = nearbySolution;
					System.out.print(solutionToString(currentSolution) + " | ");
					System.out.print(solutionToString(nearbySolution) + " | ");
					System.out.println(EcurrentSolution + "  "  + EnearbySolution + "  " + E);
					
				}
				else{
					//probabilitically accept poorer solution
					double expression = - (E / T);
					if (Math.pow(Math.E, expression) > random.nextDouble())
						currentSolution = nearbySolution;
				}
			}
			T = 0.9 * T;
			//System.out.println(T);
		}
	}
	
	public static String solutionToString(ArrayList<Edge> solution){
		String result = "";
		for (int i = 0; i < solution.size() - 1; i++){
			result += solution.get(i).getSource() + "-->";
		}
		result += solution.get(solution.size() -1).getSource();
		return result;
	}
}

import java.util.ArrayList;
import java.util.Random;
/**
 * Class Name : SA
 * Simulated Annealing algorithm
 * Author: Shengqi Gong
 * Date: 9/30/15
 * Description: Simulated Annealing algorithm of TSP problem, out put 10 random states. 
 * 
 **/
public class SA {
	public static void searchSA(Graph graph){
		Random random = new Random();
		ArrayList<Node> nodes = graph.getNodes();
		double T = Integer.MAX_VALUE;
		int count = 0;
		while(T>0.01){
			ArrayList<Edge> currentSolution = graph.visit(nodes.get(random.nextInt(nodes.size())));
			for (int i = 0; i <= 20; i++){
				ArrayList<Edge> nearbySolution = graph.visit(nodes.get(random.nextInt(nodes.size())));
				double EnearbySolution = Graph.evaluate(nearbySolution);
				double EcurrentSolution = Graph.evaluate(currentSolution);
				double E =  EnearbySolution - EcurrentSolution ;
				
				if(random.nextDouble() < 0.1 && count<10){
					count++;
					System.out.print(solutionToString(currentSolution) + " | ");
					System.out.print(solutionToString(nearbySolution) + " | ");
					System.out.println(EcurrentSolution + "  "  + EnearbySolution + "  " + E);
				}
				if (E < 0) {
					//lower engergy state is found
					
					currentSolution = nearbySolution;
					
					
				}
				else{
					//probabilitically accept poorer solution
					double expression = - (E / T);
					if (Math.pow(Math.E, expression) > random.nextDouble())
						currentSolution = nearbySolution;
				}
			}
			T = 0.7 * T;
			
		}
	}
	
	public static String solutionToString(ArrayList<Edge> solution){
		String result = "";
		for (int i = 0; i < solution.size() - 1; i++){
			if(solution.get(i) != null)
				result += solution.get(i).getSource() + "-->";
			
			else{
				result += "null" + "-->";
				return result;
			}
		}
		if(solution.get(solution.size() -1) != null){
			result += solution.get(solution.size() -1).getSource();
			return result;
		}
		else 
			return result+="null";
	}
}

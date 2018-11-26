package Graph;

public class test 
{
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		String [] cities = {"Kyiv", "Dnipro", "Paris", "Lviv"};
		for(int i = 0; i < cities.length; i++)
		{
			graph.addVertex(cities[i]);
		}
		
//		graph.addEdge("Lviv", "Kyiv", 222);
//		graph.addEdge("Lviv", "Paris", 125);
//		graph.addEdge("Kyiv", "Dnipro", 352);
//		graph.addEdge("Paris", "Dnipro", 176);
		for(int i = 0; i < cities.length; i++)
		{
			if(!cities[i].equals("Kyiv"))
			graph.addEdge("Kyiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Dnipro"))
				graph.addEdge("Dnipro", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Paris"))
				graph.addEdge("Paris", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Lviv"))
				graph.addEdge("Lviv", cities[i], (int)(Math.random()*500 + 100));
		}
		System.out.println(graph.toString());
		graph.way("Lviv", "Dnipro");
	}
}

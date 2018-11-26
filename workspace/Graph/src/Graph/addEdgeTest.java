package Graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class addEdgeTest 
{

	
	@Test
	public void test_0() 
	{
		Graph graph = new Graph();
		graph.addVertex("Kyiv");
		graph.addEdge("Kyiv", "Kyiv", 20);
		
			
	}
	
	@Test
	public void test_1() 
	{
		Graph graph = new Graph();
		String [] cities = {"Kyiv", "Dnipro", "Harkiv", "Lviv"};
		for(int i = 0; i < cities.length; i++)
		{
			graph.addVertex(cities[i]);
		}
		for(int i = 0; i < cities.length; i++)
		{
			if(!cities[i].equals("Kyiv"))
			graph.addEdge("Kyiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Dnipro"))
				graph.addEdge("Dnipro", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Harkiv"))
				graph.addEdge("Harkiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Lviv"))
				graph.addEdge("Lviv", cities[i], (int)(Math.random()*500 + 100));
		}
	}
	
	@Test
	public void test_2() 
	{
		Graph graph = new Graph();
		String [] cities = {"Kyiv", "Dnipro", "Harkiv", "Lviv"};
		for(int i = 0; i < cities.length; i++)
		{
			graph.addVertex(cities[i]);
		}
		for(int i = 0; i < cities.length; i++)
		{
			if(!cities[i].equals("Kyiv"))
			graph.addEdge("Kyiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Dnipro"))
				graph.addEdge("Dnipro", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Harkiv"))
				graph.addEdge("Harkiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Lviv"))
				graph.addEdge("Lviv", cities[i], (int)(Math.random()*500 + 100));
		}
	}
	
	@Test
	public void test_many() 
	{
		Graph graph = new Graph();
		String [] cities = {"Kyiv", "Dnipro", "Harkiv", "Lviv"};
		for(int i = 0; i < cities.length; i++)
		{
			graph.addVertex(cities[i]);
		}
		for(int i = 0; i < cities.length; i++)
		{
			if(!cities[i].equals("Kyiv"))
			graph.addEdge("Kyiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Dnipro"))
				graph.addEdge("Dnipro", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Harkiv"))
				graph.addEdge("Harkiv", cities[i], (int)(Math.random()*500 + 100));
			
			if(!cities[i].equals("Lviv"))
				graph.addEdge("Lviv", cities[i], (int)(Math.random()*500 + 100));
		}
	}

}

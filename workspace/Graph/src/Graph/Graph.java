package Graph;

import java.util.ArrayList;

public class Graph implements Cloneable, Comparable<Graph>
{
	private Vertex root = null;
	
	class Vertex implements Comparable<Vertex>
	{
		String val = "";
		Vertex next = null;
		Edge root = null;
		boolean isVisited = false;
		
		public Vertex(String val)
		{
			this.val = val;
		}
		
		public String toString()
		{
			String result = val+"\n\t\t{routs:\n\t\t";
			
			if(root == null)
			{
				result = result.substring(0, result.length()-3);
				result += "}";
				return result;
			}
			
			Edge tmp = root;
			result += tmp.toString() + "\n\t\t";
			
			while(tmp.next != null)
			{
				tmp = tmp.next;
				result += tmp.toString() + "\n\t\t";
			}
			
			result = result.substring(0, result.length()-3);
			result += "}";
			
			return result;
		}

		@Override
		public int compareTo(Vertex vertex) 
		{
			if(toString().equals(vertex.toString()))
				return 0;
			else
			{
				
				return 1;
			}
		}
	}
	
	class Edge
	{
		int val = 0;
		Edge next = null;
		Vertex vr = null;
		
		public Edge(int val)
		{
			this.val = val;
		}
		
		public String toString()
		{
			String result = val + " to " + vr.val;
			
			return result;
		}
	}
	
	void addEdge(String from, String to, int val)
	{
		if(from.equals(to))
		{
			System.out.println("edge not added because from == to");
			return;
		}
		
		Vertex From = searchVertex(from);
		Vertex To = searchVertex(to);
		
		if(From == null)
		{
			addVertex(from);
			From = searchVertex(from);
		}
		
		if(To == null)
		{
			addVertex(to);
			To = searchVertex(to);
		}
		
		if(From.root == null)
		{
			From.root = new Edge(val);
			From.root.vr = To;
		}
		else
		{
			Edge tmp = From.root;
			while(tmp != null)
			{
				if(tmp.vr == To && tmp.val == val)
					return;
				
				if(tmp.next == null)
				{
					tmp.next = new Edge(val);
					tmp.next.vr = To;
				}
				
				tmp = tmp.next;
			}
		}
	}
	
	void addVertex(String val)
	{
		if(root == null)
			root = new Vertex(val);
		else
		{
			Vertex tmp = root;
			while(tmp != null)
			{
				if(tmp.val == val)
					return;
				
				if(tmp.next == null)
					tmp.next = new Vertex(val);
				
				tmp = tmp.next;
			}	
		}
	}
	
	void delEdge(String from, String to)
	{
		Vertex From = searchVertex(from);
		Vertex To = searchVertex(to);
		if(From == null || To == null)
		{
			System.out.println("such a edge not found");
			return;
		}
		Edge tmp = From.root;
		
		while(tmp != null)
		{
			if(tmp.vr == To)
			{
				delEdge(tmp, From);
				return;
			}
			tmp = tmp.next;
		}
	}
	
	void delEdge(Edge del, Vertex from)
	{
		if(del == from.root)
			from.root = from.root.next;
		else
		{
			Edge tmp = from.root;
		
			while(tmp.next != null)
			{
				Edge prew = tmp;
				tmp = tmp.next;
				if(tmp == del)
				{
					prew.next = tmp.next;
					return;
				}
			}
		}
	}
	
	void delVertex(String val)
	{
		if(searchVertex(val) == null)
			return;
		
		if(searchVertex(val) == root)
			root = root.next;
		else
		{
			Vertex tmp = root;
			
			while(tmp.next != null)
			{
				Vertex prew = tmp;
				tmp = tmp.next;
				if(tmp.val == val)
				{
					prew.next = tmp.next;
					checkEdge();
					return;
				}
			}
		}
	}
	
	private void checkEdge() 
	{
		if(root == null)
			return;
		
		Vertex tmp = root;
		while(tmp != null)
		{
			Edge tmpE = tmp.root;
			while(tmpE != null)
			{
				if(tmpE.vr == null)
				{
					Edge forDelete = tmpE;
					tmpE = tmpE.next;
					delEdge(forDelete, tmp);
				}
				else 
					tmpE = tmpE.next;
			}
			tmp = tmp.next;
		}
	}

	Vertex searchVertex(String val)
	{
		Vertex tmp = root;	
		Vertex result = null;
		
		while(tmp != null)
		{
			if(tmp.val.equals(val))
				result = tmp;
			
			tmp = tmp.next;
		}
		return result;
	}
	
	public String toString()
	{
		String result = "Graph\n\t[cities:\n\t";
		
		if(root == null)
		{
			result = result.substring(0, result.length()-2);
			result += "]";
			return result;
		}
		
		Vertex tmp = root;
		
		while(tmp != null)
		{
			result += tmp.toString() + "\n\t";
			tmp = tmp.next;
		}
		
		result = result.substring(0, result.length()-2);
		result += "]";
		
		return result;
	}
	
	private class GetWay
	{
		ArrayList<Graph> ways = new ArrayList<Graph>();
		ArrayList<Integer> distance = new ArrayList<Integer>();
		int limit;
		int dist = 0;
		String from, to;
		
		public GetWay(int limit)
		{
			this.limit = limit;
		}
		
		public void way(Vertex from, String to)
		{
			this.to = to;
			this.from = from.val;
			Graph way = new Graph();
			way.addVertex(from.val);
			getWay(way, from, 0);
		}
			


		private void getWay(Graph way, Vertex from, int lvl)
		{

			if(to.equals(from.val))
			{
				ways.add(way);
				distance.add(dist);
				return;
			}
			
			if(from.root == null || lvl >= limit)
				return;
			
			if(from.val == this.from && lvl > 0)
				return;
			
			Edge eg = from.root;
			while(eg != null)
			{
				way.addEdge(from.val, eg.vr.val, eg.val);
				Graph ww = (Graph) way.clone();
				dist += eg.val;
				getWay(ww, eg.vr, lvl+1);
				dist -= eg.val;
				way.delEdge(from.val, eg.vr.val);
				way.delVertex(to);;
				eg = eg.next;
			}
		}



		public void printAll() 
		{
			for(Integer d:distance)
			{
				Graph way = ways.get(distance.indexOf(d));
				String result = way.root.val + " ";
				Vertex tmp = way.root;
				while(tmp.root != null)
				{
					result += tmp.root.toString() + " ";
					tmp = tmp.root.vr;
				}
				result += "= " + d.intValue();
				System.out.println(result);
			}
		}



		public void printMin() 
		{
			Integer min = distance.get(0);
			for(Integer d:distance)
			{
				if(d < min)
					min = d;
			}
			Graph minWay = ways.get(distance.indexOf(min));
			String result = minWay.root.val + " ";
			Vertex tmp = minWay.root;
			while(tmp.root != null)
			{
				result += tmp.root.toString() + " ";
				tmp = tmp.root.vr;
			}
			result += "= " + min.intValue();
			System.out.println(result);
		}
	}
	
	void way(String from, String to)
	{
		Vertex From = searchVertex(from);
		Vertex To = searchVertex(to);
		String result = "";
		if(From.root == null || From == null || To == null)
			System.out.println(result);
		else
		{
			GetWay gw = new GetWay(3); //функционально можно передавать в конструктор лимит
			gw.way(From, to); 
			//gw.printAll();
			gw.printMin();
		}
	}

	
	@Override
	public Object clone()
	{
		Graph graph = new Graph();
		Vertex vertex = root;
		
		while(vertex != null)
		{
			graph.addVertex(vertex.val);
			Edge edge = vertex.root;
			while(edge != null)
			{
				graph.addEdge(vertex.val, edge.vr.val, edge.val);
				edge = edge.next;
			}
			vertex = vertex.next;
		}
		return graph;
	}

	@Override
	public int compareTo(Graph graph)
	{
		if(toString().equals(graph.toString()))
			return 0;
		else 
			return 1;
	}
}

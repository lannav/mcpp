

import java.awt.Color;

public class PData 
{
	 String type = "line";
	 int clr = Color.BLACK.getRGB();
	 int width = 1;
	
	private static PData instance = null;
	
	private PData(String type, int width, int clr)
	{
		this.type = type;
		this.clr = clr;
		this.width = width;
	}
	private PData(){}
	
	public static PData getInstance()
	{
		if(instance == null)
			instance = new PData();
		
		return instance;
	}
}

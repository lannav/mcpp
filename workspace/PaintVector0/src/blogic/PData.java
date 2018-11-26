package blogic;

import java.awt.Color;

public class PData 
{
	 public String type = "line";
	 public int clr = Color.BLACK.getRGB();
	 public int width = 1;
	
	private static PData instance = null;
	
	private PData(String type, int width, int clr)
	{
		instance = this;
		this.type = type;
		this.clr = clr;
		this.width = width;
	}
	private PData()
	{
		instance = this;
	}
	
	public static PData getInstance()
	{
		if(instance == null)
			instance = new PData();
		
		return instance;
	}
}

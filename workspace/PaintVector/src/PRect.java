import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PRect implements PShape
{
	int x,y,x2,y2;
	int clr;
	int width;
	
	public PRect(int x, int y, int x2, int y2, int clr, int width)
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;
	}
	
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawRect(x, y, Math.abs(x2-x), Math.abs(y2-y));
	}
	
	public int[] getParameters()
	{
		int[] arr = {x,y,x2,y2,clr,width};
		return arr;
	}
}

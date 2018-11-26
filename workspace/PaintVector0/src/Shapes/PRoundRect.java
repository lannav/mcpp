package Shapes;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PRoundRect implements PShape
{
	int x,y,x2,y2;
	int clr;
	int width;
	
	public PRoundRect(int x, int y, int x2, int y2, int clr, int width)
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
		gg.drawRoundRect(x, y, Math.abs(x2-x), Math.abs(y2-y), Math.abs(x2-x)/4, Math.abs(y2-y)/4);
	}
	
	public int[] getParameters()
	{
		int[] arr = {x,y,x2,y2,clr,width};
		return arr;
	}
}

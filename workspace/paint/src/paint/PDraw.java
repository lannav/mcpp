package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PDraw extends JPanel 
{
	int x;
	int y;
	int x2;
	int y2;
	int x3;
	int y3;
	int x4;
	int y4;
	PData data = null;
	
	public PDraw(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4, PData data)
	{
		this.data = data;
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
	}
	
	
	public void draw(Graphics2D gg)
	{
		gg.setColor(data.clr);
		gg.setStroke(new BasicStroke(data.width));
			
		switch(data.type)
		{
		 case "curve" : gg.drawLine(x3, y3, x4, y4); break;
		 case "line"  : gg.drawLine(x, y, x2, y2); break;
		 case "rect"  : gg.drawRect(x, y, Math.abs(x2-x), Math.abs(y2-y)); break;
		 case "Rrect" : gg.drawRoundRect(x, y, Math.abs(x2-x), Math.abs(y2-y), Math.abs(x2-x)/4, Math.abs(y2-y)/4); break;
		 case "oval"  : gg.drawOval(x, y, Math.abs(x2-x), Math.abs(y2-y)); break;
		 default : break;
		}
	}
}

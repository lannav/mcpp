package BsTreePainter;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TrDraw extends BsTree
{
	public void draw(JPanel pnl)
	{
		drawNode(root, (Graphics2D)pnl.getGraphics(), 0, pnl.getWidth(), 1, 100, pnl.getWidth()/2, 0);
	}
	
	private void drawNode(Node p, Graphics2D g, int left, int right, int lvl, int dy, int lx, int ly) 
	{
		if(p == null)
			return;
		
		int x = (left + right)/2;
		int y = lvl*dy;
		
		g.drawString(""+p.val, x, y);
		g.drawOval(x-10, y-20, 30, 30);
		g.drawLine(x+5, y-20, lx+5, ly);
		
		drawNode(p.left, g, left, x, lvl+1, dy, x-5, y+10);
		drawNode(p.right, g, x, right, lvl+1, dy, x+5, y+10);
	}
}

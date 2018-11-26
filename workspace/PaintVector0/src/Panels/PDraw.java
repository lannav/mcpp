package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import Shapes.PCurve;
import Shapes.PLine;
import Shapes.POval;
import Shapes.PRect;
import Shapes.PRoundRect;
import Shapes.PShape;
import blogic.PData;

public class PDraw extends JPanel implements MouseListener, MouseMotionListener
{
	public ArrayList<PShape> pp = new ArrayList<PShape>();
	public BufferedImage bi = null;
	PShape shape;
	int x,y;
	PData data = PData.getInstance();
	
	public PDraw(PPanel ppnl)
	{
		ppnl.alpd.add(this);
		setBounds(150,10,760,570);
		setBackground(Color.WHITE);
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		if ((arg0.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK)) return;
		
			if(data.type == "curve")
			{
			int x2 = arg0.getX();
			int y2 = arg0.getY();
			shape = new PCurve(x,y,x2,y2,data.clr,data.width);
			pp.add(shape);
			x = x2;
			y = y2;
			repaint();
			}
	}
	
	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
		Graphics2D gg = (Graphics2D) arg0;
		if(bi != null)
			gg.drawImage(bi,0,0,null);
		for(PShape shape:pp)
			shape.draw(gg);
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		if(arg0.getButton()==MouseEvent.BUTTON1)
		{
		x = arg0.getX();
		y = arg0.getY();
		}
	}


	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		if(arg0.getButton()==MouseEvent.BUTTON1)
		{
			int x2 = arg0.getX();
			int y2 = arg0.getY();
			
			if(x2 < x)
			{
				int tmp = x;
				x = x2;
				x2 = tmp;
			}
			if(y2 < y)
			{
				int tmp = y;
				y = y2;
				y2 = tmp;
			}
			
			switch(data.type)
			{
			case "line"  : shape = new PLine(x,y,x2,y2,data.clr,data.width);      break;
			case "rect"  : shape = new PRect(x,y,x2,y2,data.clr,data.width);      break;
			case "Rrect" : shape = new PRoundRect(x,y,x2,y2,data.clr,data.width); break;
			case "oval"  : shape = new POval(x,y,x2,y2,data.clr,data.width);      break;
			}
			pp.add(shape);
			repaint();	
		}
	}
}

package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PPanel extends JPanel implements MouseListener, MouseMotionListener
{
	PData data = new PData();
	PCommand cmd = new PCommand(data);
	PType type   = new PType(cmd);
	PWidth width = new PWidth(cmd);
	PColor color = new PColor(cmd);
	
	int x, y, x2, y2;
	int x3, y3, x4, y4;
	BufferedImage bi = new BufferedImage(540, 380, BufferedImage.SCALE_DEFAULT);
	
	public PPanel()
	{
		setLayout(null);
		setBounds(10, 10, 600, 420);
		type.setBounds(10, 10, 140, 160);
		type.setBackground(Color.cyan);
		add(type);
		width.setBounds(10, 180, 140, 100);
		width.setBackground(Color.magenta);
		add(width);
		color.setBounds(10, 290, 140, 100);
		color.setBackground(Color.yellow);
		add(color);
		//draw.setBounds(150, 10, 540, 380);
		//draw.setBackground(Color.white);
		//add(draw);
		
		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.fillRect(0, 0, 540, 380);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		x4 = arg0.getX();
		y4 = arg0.getY();
		PDraw p = new PDraw(0,0,0,0,x3-150,y3-10,x4-150,y4-10,data);
		p.draw((Graphics2D)bi.getGraphics());
		x3 = x4;
		y3 = y4;
		repaint();
	}
	
	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
		Graphics2D gg = (Graphics2D) arg0;
		gg.drawImage(bi,150,10,null);
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
		x = arg0.getX();
		y = arg0.getY();
		x3 = arg0.getX();
		y3 = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		 x2 = arg0.getX();
		 y2 = arg0.getY();
		PDraw p = new PDraw(x-150,y-10,x2-150,y2-10,0,0,0,0,data);
		p.draw((Graphics2D)bi.getGraphics());
		x = x2;
		y = y2;
		repaint();
	}
}

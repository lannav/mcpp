package BallExtJpanelThread;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Ball extends JPanel implements Runnable
{
	int R = 50;
	int dx = 1;
	int dy = 1;
	int clr = (int)(Math.random() *10000000);
	Point p;
	Thread tr;

	public Ball(int x, int y)
	{
		tr = new Thread(this);
		tr.start();
		setBounds(x-R, y-R, R+2, R+2);
		p = getLocation();
	}
	
	public void move()
	{
		if(p.x + R >= 785 - R)
			dx *= -1;
		if(p.x + R <= 0 + R)
			dx *= -1;
		if(p.y + R >= 560 - R)
			dy *= -1;
		if(p.y + R <= 0 + R)
			dy *= -1;
		
		p.x += dx;
		p.y += dy;
		
		setLocation(p);
		
	}

	@Override
	public void run() 
	{
		while(true)
		{
			move();
			try {
				tr.sleep(10);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void paint(Graphics g)
	{
		g.setColor(new Color(clr));
		g.fillOval(p.x, p.y, R*2, R*2);
	}
}

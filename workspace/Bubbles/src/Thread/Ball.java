package Thread;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Thread
{
	BPanel bpn;
	int x,y;
	int R = 50;
	int dx, dy;
	int clr = (int)(Math.random() *10000000);
	int minRangeX, maxRangeX, minRangeY, maxRangeY;

	public Ball(int x, int y, BPanel bpn)
	{
		dx = 1;
		this.x = x;
		this.y = y;
		dy = 1;
	}
	
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(1));
		gg.fillOval(x-R, y-R, R*2, R*2);
	}
	
	public void move()
	{
		if(x >= 785 - R)
			dx *= -1;
		if(x <= 0 + R)
			dx *= -1;
		if(y >= 560 - R)
			dy *= -1;
		if(y <= 0 + R)
			dy *= -1;
		
		x += dx;
		y += dy;
		
	}
	
	@Override
	public void run()
	{
		
	}
}

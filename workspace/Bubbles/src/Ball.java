import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball
{
	int x,y;
	int R = (int)(Math.random()*10+10);
	int dx, dy;
	int clr = Color.red.getRGB();

	public Ball(int x, int y)
	{
		dx = getD();
		this.x = x;
		this.y = y;
		dy = getD();
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
	public int getD()
	{
		int rs = (int)(Math.random()*12-6);
		while(rs == 0)
			rs = (int)(Math.random()*12-6);
		return rs;
	}
	
	public void rev()
	{
		dx *= -1;
		dy *= -1;
	}
}

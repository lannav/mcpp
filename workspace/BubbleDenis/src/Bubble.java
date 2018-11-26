import java.awt.Color;
import java.awt.Graphics2D;

public class Bubble extends Thread
{
	volatile	BCommand command;
	volatile	int x;
	volatile	int y;
	volatile	int dx;
	volatile	int dy;
	volatile	int radius = 50;
	volatile	int minRangeX;
	volatile	int maxRangeX;
	volatile	int minRangeY;
	volatile	int maxRangeY;
	volatile	int clr = (int)(Math.random() *10000000);
	volatile    BPanel panel;
	

	public Bubble( int x, int y,BCommand command, BPanel panel)
	{
		this.command = command;
		x = x - 50;
		y = y - 50;
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
	    this.panel = panel;
	    this.start();
	}


	public  void draw(Graphics2D g)   
	{
		g.setColor(new Color(clr));
		g.fillOval(x, y, radius*2, radius*2);
	}

	public void move()
	{
		if(x <= 0)
		{
			dx = 1;
		}

		if(y <= 0) 
		{
			dy = 1;
		}

		if(x >= 685) 
		{
			dx = -1;
		}

		if(y >= 465)
		{
			dy = -1;
		}
		x+=dx;
		y+=dy;
		minRangeX = x;
		maxRangeX = x + 100;
		minRangeY = y;
		maxRangeY = y + 100;	
	}


	public void repulsion()
	{
		for(Bubble bubble : command.arr)
		{
			if(bubble == null)
			{
				return;
			}

			for(Bubble ball : command.arr)
			{
				if(bubble == ball)
				{
					continue;	
				}
				if(intersection(bubble, ball) == true )
				{
					//bubble справа, снизу
					if(bubble.minRangeX > ball.minRangeX  && bubble.minRangeX <= ball.maxRangeX && bubble.maxRangeY >= ball.minRangeY && bubble.maxRangeY < ball.maxRangeY && ball != bubble)
					{
						bubble.dy = -1;
						bubble.dx = +1;
						ball.dy = +1;
						ball.dx = -1;
					}
					
					//bubble справа, вверху
					if(bubble.minRangeX > ball.minRangeX && bubble.minRangeX <= ball.maxRangeX && bubble.minRangeY > ball.minRangeY && bubble.minRangeY <= ball.maxRangeY && ball != bubble)
					{
						bubble.dy = +1;
						bubble.dx = +1;
						ball.dy = -1;
						ball.dx = -1;
					}

			        //bubble слева, сверху
					if(bubble.maxRangeX >= ball.minRangeX && bubble.maxRangeX < ball.maxRangeX && bubble.maxRangeY > ball.minRangeY && bubble.minRangeY <= ball.maxRangeY && ball != bubble)
					{
						bubble.dy = +1;
						bubble.dx = -1;
						ball.dy = -1;
						ball.dx = +1;
					}
					
					//bubble слева, снизу
					if(bubble.maxRangeX >= ball.minRangeX && bubble.maxRangeX < ball.maxRangeX && bubble.minRangeY < ball.minRangeY && bubble.maxRangeY >= ball.minRangeY && ball != bubble)
					{
						bubble.dy = -1;
						bubble.dx = -1;
						ball.dy = +1;
						ball.dx = +1;
					}

					//bubble справа
					if(bubble.minRangeX > ball.minRangeX  && bubble.minRangeX <= ball.maxRangeX && bubble.minRangeY == ball.minRangeY && bubble.maxRangeX == ball.maxRangeX && ball != bubble)
					{
						bubble.dx = +1;
						bubble.dy = 0;
						ball.dx = -1;
						ball.dy = 0;
					}
					
					//bubble слева
					if(bubble.minRangeX < ball.minRangeX  && bubble.maxRangeX >= ball.minRangeX && bubble.minRangeY == ball.minRangeY && bubble.maxRangeX == ball.maxRangeX && ball != bubble)
					{
						bubble.dx = -1;
						bubble.dy = 0;
						ball.dx = +1;
						ball.dy = 0;
					}
					
					//bubble сверху
					if(bubble.minRangeX == ball.minRangeX  && bubble.maxRangeX == ball.maxRangeX && bubble.minRangeY > ball.minRangeY && bubble.minRangeY <= ball.maxRangeY && ball != bubble)
					{
						bubble.dy = +1;
						bubble.dx = 0;
						ball.dy = -1;
						ball.dx = 0;
					}
					
					//bubble снизу
					if(bubble.minRangeX == ball.minRangeX  && bubble.maxRangeX == ball.maxRangeX && bubble.maxRangeY < ball.maxRangeY && bubble.maxRangeY >= ball.minRangeY && ball != bubble)
					{
						bubble.dy = -1;
						bubble.dx = 0;
						ball.dy = +1;
						ball.dx = 0;
					}
				}
			}
		}
	}
		
	private boolean intersection(Bubble a, Bubble b)
	{
			boolean res = false;

		if( Math.sqrt(Math.pow((b.x - a.x),2) + Math.pow((b.y - a.y),2)) <= (a.radius + b.radius) )
			res = true;
		
		if(a == b)
			res = false;
		
		return res;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			this.repulsion();
			this.move();
			try 
			{
				sleep(10);	
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}	
		}
	}
}

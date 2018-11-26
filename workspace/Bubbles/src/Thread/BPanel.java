package Thread;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BPanel extends JPanel implements MouseListener
{
	ArrayList<Ball> pp = new ArrayList<Ball>();
	
	ActionList alis = new ActionList();
	
	class ActionList implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			repaint();
		}
		
	}
	
	public BPanel()
	{
		Point p = new Point();
		addMouseListener(this);
		setBounds(0,0,600,800);
		Timer tm = new Timer(10, alis);
		tm.start();
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D)g;
		for(Ball b : pp)
		{
			b.draw(gg);
			b.move();
		}
		repulsion();
	}
	
	public void repulsion()
	{
		for(Ball bubble : pp)
		{
			if(bubble == null)
			{
				return;
			}

			for(Ball ball : pp)
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
		
	private boolean intersection(Ball a, Ball b)
	{
			boolean res = false;

		if( Math.sqrt(Math.pow((b.x - a.x),2) + Math.pow((b.y - a.y),2)) <= (a.R + b.R) )
			res = true;
		
		if(a == b)
			res = false;
		
		return res;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
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
		Ball b = new Ball(arg0.getX(), arg0.getY(), this);
		pp.add(b);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

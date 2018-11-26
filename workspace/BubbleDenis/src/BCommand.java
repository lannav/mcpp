import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BCommand implements MouseListener
{
	BCommand command = this;
	BPanel panel;
	Timer timer;
	volatile ArrayList <Bubble>  arr = new ArrayList <Bubble>();
	
	public BCommand(BPanel panel)
	{
		this.panel = panel;
		this.timer = new Timer();
	}

	public class Timer implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			panel.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			int x = e.getX();
			int y = e.getY();
			Bubble  bubble = new Bubble(x,y,command,panel);
			arr.add(bubble);
		}
		
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			Bubble del = null;
			for(Bubble bubble : arr)
			{
				if(bubble == null)
				{
					return;
				}
				if(e.getX() <=  bubble.maxRangeX && e.getX()  >=  bubble.minRangeX && e.getY()  >=  bubble.minRangeY && e.getY() <=  bubble.maxRangeY )
				{
					del = bubble;
				}
			}
			arr.remove(del);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub	
	}
}

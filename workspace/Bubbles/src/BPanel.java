import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		for(int i = pp.size() - 1; i >= 0; i--)
			for(int j = 0; j < i; j++)
				if( intersection(pp.get(i),pp.get(j)) )
				{
					pp.get(i).rev();
					pp.get(j).rev();
					return;
				}
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
		Ball b = new Ball(arg0.getX(), arg0.getY());
		pp.add(b);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BPanel extends JPanel
{
	BCommand command;
	
	BPanel()
	{
		this.command = new BCommand(this);
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(Color.lightGray);
		addMouseListener(command);
		
		Timer timer = new Timer(10, command.timer);
		timer.start();
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (Bubble bubble : command.arr)
		{
			bubble.draw(gg);
//			bubble.repulsion();
//			bubble.move();
		}		
	}
}

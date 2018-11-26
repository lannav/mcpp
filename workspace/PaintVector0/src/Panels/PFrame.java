package Panels;
import javax.swing.JFrame;

public class PFrame extends JFrame
{	
	public PFrame()
	{
		setLayout(null);
		setBounds(30,30,1000,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PPanel(this));
        setVisible(true);
	}
}

package paint;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	PFrame()
	{
		setBounds(100,100,720,440);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PPanel());
		setVisible(true);
	}
}

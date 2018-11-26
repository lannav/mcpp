package BallExtJpanelThread;

import javax.swing.JFrame;

public class BFrame extends JFrame
{
	BFrame()
	{
		setTitle("ball");
		setBounds(50,50,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new BPanel());
		setVisible(true);
	}
}

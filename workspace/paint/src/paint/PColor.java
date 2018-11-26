package paint;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PColor extends JPanel
{
	PCommand cmd = null;
	
	public PColor(PCommand cmd)
	{
		JButton red = new JButton("RED");
		JButton green = new JButton("GREEN");
		JButton blue = new JButton("BLUE");
		
		setLayout(null);
		
		red.setActionCommand("red");
		red.addActionListener(cmd.aColor);
		red.setBounds(10, 10, 120, 20);
		add(red);
		
		green.setActionCommand("green");
		green.addActionListener(cmd.aColor);
		green.setBounds(10, 40, 120, 20);
		add(green);
		
		blue.setActionCommand("blue");
		blue.addActionListener(cmd.aColor);
		blue.setBounds(10, 70, 120, 20);
		add(blue);
	}
}

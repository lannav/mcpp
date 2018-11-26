import java.awt.Color;

import javax.swing.JFrame;

public class CFrame extends JFrame
{
	public CFrame()
	{
		setTitle("Calculator");
		setBackground(Color.lightGray);
		setBounds(200,200,265,390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new CPanel());
		setVisible(true);
	}
}

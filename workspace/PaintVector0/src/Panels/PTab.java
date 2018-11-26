package Panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import blogic.PCommand;

public class PTab extends JPanel
{
	public PTab(PCommand cmd)
	{
		JButton add = new JButton("addTab");
		JButton del = new JButton("delTab");
		setLayout(null);
		del.setActionCommand("del");
		add.setActionCommand("add");
		
		add.addActionListener(cmd.aAdd);
		add.setBounds(10, 0, 120, 20);
		add(add);
		
		del.addActionListener(cmd.aAdd);
		del.setBounds(130, 0, 120, 20);
		add(del);
	}
}

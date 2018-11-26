package Panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import blogic.PCommand;

public class PImpExp extends JPanel
{
	public PImpExp(PCommand cmd, PPanel ppnl)
	{
		JButton saveBtn = new JButton("SAVE");
		JButton loadBtn = new JButton("LOAD");
		setLayout(null);
		int act = 0;
		for(int i = 0; i < ppnl.alpd.size(); i++)
		{
			if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
				act = i;
		}
		
		saveBtn.addActionListener(cmd.aSave);
		saveBtn.setBounds(10, 10, 120, 20);
		add(saveBtn);
		
		loadBtn.addActionListener(cmd.aLoad);
		loadBtn.setBounds(10, 40, 120, 20);
		add(loadBtn);
	}
}

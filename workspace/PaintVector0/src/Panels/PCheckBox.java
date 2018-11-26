package Panels;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import blogic.PCommand;

public class PCheckBox extends JPanel
{
	public JCheckBox menu;
	public JCheckBox toolB;
	public JCheckBox context;

	public PCheckBox(PCommand cmd) 
	{
		
		menu = new JCheckBox("menu");
		toolB = new JCheckBox("tool bar");
		context = new JCheckBox("context menu");
		menu.setBackground(Color.green);
		toolB.setBackground(Color.green);
		context.setBackground(Color.green);
		menu.addItemListener(cmd.aCheck);
		toolB.addItemListener(cmd.aCheck);
		context.addItemListener(cmd.aCheck);
		add(menu);
		add(toolB);
		add(context);
		
		
	}
}

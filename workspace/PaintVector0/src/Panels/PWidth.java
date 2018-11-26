package Panels;


import javax.swing.JButton;
import javax.swing.JPanel;

import blogic.PCommand;

public class PWidth extends JPanel
{
	public PWidth(PCommand cmd)
	{
		JButton bt2 = new JButton("1");
		JButton bt4 = new JButton("2");
		JButton bt6 = new JButton("4");
		
		setLayout(null);
		
		bt2.setActionCommand("bt1");
		bt2.addActionListener(cmd.aWidth);
		bt2.setBounds(10, 10, 120, 20);
		add(bt2);
		
		bt4.setActionCommand("bt2");
		bt4.addActionListener(cmd.aWidth);
		bt4.setBounds(10, 40, 120, 20);
		add(bt4);
		
		bt6.setActionCommand("bt4");
		bt6.addActionListener(cmd.aWidth);
		bt6.setBounds(10, 70, 120, 20);
		add(bt6);
	}
}

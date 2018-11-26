package Panels;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import blogic.PCommand;

public class PPanel extends JPanel 
{
	public JTabbedPane tabbedPane;
	public ArrayList<PDraw> alpd = new ArrayList<PDraw>();
	public PCheckBox pcb;
	PPanel(PFrame frame)
	{
		PCommand cmd = new PCommand(frame, this);
		PType type   = new PType(cmd);
		PWidth width = new PWidth(cmd);
		PColor color = new PColor(cmd);
		PDraw pdr = new PDraw(this);
		tabbedPane = new JTabbedPane();
		setLayout(null);
		tabbedPane.setBounds(150,20,760,570);
		add(tabbedPane);
		tabbedPane.addTab("tab", pdr);
		setBounds(10,40,910,655);
		type.setBounds(10, 10, 140, 160);
		type.setBackground(Color.cyan);
		add(type);
		width.setBounds(10, 180, 140, 100);
		width.setBackground(Color.magenta);
		add(width);
		color.setBounds(10, 290, 140, 130);
		color.setBackground(Color.yellow);
		add(color);
		PImpExp pie = new PImpExp(cmd, this);
		pie.setBounds(10, 430, 140, 70);
		pie.setBackground(Color.orange);
		add(pie);
		pcb = new PCheckBox(cmd);
		pcb.setBounds(10, 510, 140, 65);
		pcb.setBackground(Color.green);
		add(pcb);
		PTab tab = new PTab(cmd);
		tab.setBounds(650, 0, 270, 40);
		add(tab);
	}
}

package Panels;


import javax.swing.JButton;
import javax.swing.JPanel;
import blogic.PCommand;

public class PType extends JPanel
{
	public PType(PCommand cmd)
	{
		JButton curve = new JButton("CURVE");
		JButton line = new JButton("LINE");
		JButton rect = new JButton("RECTANGLE");
		JButton Rrect = new JButton("ROUND RECTANGLE");
		JButton oval = new JButton("OVAL");
		
		setLayout(null);
		
		curve.setActionCommand("curve");
		curve.addActionListener(cmd.aType);
		curve.setBounds(10, 10, 120, 20);
		add(curve);
		
		line.setActionCommand("line");
		line.addActionListener(cmd.aType);
		line.setBounds(10, 40, 120, 20);
		add(line);
		
		rect.setActionCommand("rect");
		rect.addActionListener(cmd.aType);
		rect.setBounds(10, 70, 120, 20);
		add(rect);
		
		Rrect.setActionCommand("Rrect");
		Rrect.addActionListener(cmd.aType);
		Rrect.setBounds(10, 100, 120, 20);
		add(Rrect);
		
		oval.setActionCommand("oval");
		oval.addActionListener(cmd.aType);
		oval.setBounds(10, 130, 120, 20);
		add(oval);
	}
}

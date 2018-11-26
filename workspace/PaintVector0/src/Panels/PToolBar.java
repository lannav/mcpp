package Panels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import blogic.PCommand;

public class PToolBar extends JPanel
{
	public JToolBar tb;
	
	public PToolBar(PCommand cmd)
	{
		tb = new JToolBar();
        JButton r = new JButton(new ImageIcon("E:\\eclipse\\libVP\\red.png"));
        r.setActionCommand("red");
		r.addActionListener(cmd.aColor);
        JButton g = new JButton(new ImageIcon("E:\\eclipse\\libVP\\green.png"));
        g.setActionCommand("green");
		g.addActionListener(cmd.aColor);
        JButton b = new JButton(new ImageIcon("E:\\eclipse\\libVP\\blue.png"));
        b.setActionCommand("blue");
		b.addActionListener(cmd.aColor);
		JButton ri = new JButton(new ImageIcon("E:\\eclipse\\libVP\\rainb.png"));
		ri.setActionCommand("rainb");
		ri.addActionListener(cmd.aColor);
        JButton p1 = new JButton(new ImageIcon("E:\\eclipse\\libVP\\w1.png"));
        p1.setActionCommand("bt1");
		p1.addActionListener(cmd.aWidth);
        JButton p2 = new JButton(new ImageIcon("E:\\eclipse\\libVP\\w2.png"));
        p2.setActionCommand("bt2");
		p2.addActionListener(cmd.aWidth);
        JButton p4 = new JButton(new ImageIcon("E:\\eclipse\\libVP\\w4.png"));
        p4.setActionCommand("bt4");
		p4.addActionListener(cmd.aWidth);
        JButton lin = new JButton(new ImageIcon("E:\\eclipse\\libVP\\line.png"));
        lin.setActionCommand("line");
		lin.addActionListener(cmd.aType);
        JButton cur = new JButton(new ImageIcon("E:\\eclipse\\libVP\\curve.png"));
        cur.setActionCommand("curve");
		cur.addActionListener(cmd.aType);
        JButton rec = new JButton(new ImageIcon("E:\\eclipse\\libVP\\rect.png"));
        rec.setActionCommand("rect");
		rec.addActionListener(cmd.aType);
        JButton rrec = new JButton(new ImageIcon("E:\\eclipse\\libVP\\rrect.png"));
        rrec.setActionCommand("Rrect");
		rrec.addActionListener(cmd.aType);
        JButton ova = new JButton(new ImageIcon("E:\\eclipse\\libVP\\oval.png"));
        ova.setActionCommand("oval");
		ova.addActionListener(cmd.aType);
		JButton s = new JButton(new ImageIcon("E:\\eclipse\\libVP\\floppy.png"));
		s.addActionListener(cmd.aSave);
		JButton l = new JButton(new ImageIcon("E:\\eclipse\\libVP\\load.png"));
		l.addActionListener(cmd.aLoad);
        tb.add(r);
        tb.add(g);
        tb.add(b);
        tb.add(ri);
        tb.addSeparator();
        tb.addSeparator();
        tb.add(p1);
        tb.add(p2);
        tb.add(p4);
        tb.addSeparator();
        tb.addSeparator();
        tb.add(lin);
        tb.add(cur);
        tb.add(rec);
        tb.add(rrec);
        tb.add(ova);
        tb.addSeparator();
        tb.addSeparator();
        tb.add(s);
        tb.add(l);
        tb.addSeparator();
        
        JButton add = new JButton("addTab");
		JButton del = new JButton("delTab");
		del.setActionCommand("del");
		add.setActionCommand("add");
		
		add.addActionListener(cmd.aAdd);
		tb.add(add);
		del.addActionListener(cmd.aAdd);
		tb.add(del);
		tb.setBounds(0, 0, 640, 35);
	}
}

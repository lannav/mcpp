package Panels;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import blogic.PCommand;

public class PMenu extends JPanel
{
	public JMenuBar mBar;
	
	public PMenu(PCommand cmd)
	{
		mBar = new JMenuBar();

        JMenu fMenu = new JMenu("File");
        mBar.add(fMenu);
        JMenu color = new JMenu("Color");
        mBar.add(color);
        JMenu type = new JMenu("Type");
        mBar.add(type);
        JMenu width = new JMenu("Width");
        mBar.add(width);
        
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(cmd.aSave);
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(cmd.aLoad);
        fMenu.add(save);
        fMenu.add(load);
        
        JMenuItem red = new JMenuItem("Red");
        red.setActionCommand("red");
		red.addActionListener(cmd.aColor);
        JMenuItem green = new JMenuItem("Green");
        green.setActionCommand("green");
		green.addActionListener(cmd.aColor);
        JMenuItem blue = new JMenuItem("Blue");
        blue.setActionCommand("blue");
		blue.addActionListener(cmd.aColor);
        color.add(red);
        color.add(green);
        color.add(blue);
        
        JMenuItem curve = new JMenuItem("Curve");
        curve.setActionCommand("curve");
		curve.addActionListener(cmd.aType);
        JMenuItem line = new JMenuItem("Line");
        line.setActionCommand("line");
		line.addActionListener(cmd.aType);
        JMenuItem rect = new JMenuItem("Rect");
        rect.setActionCommand("rect");
		rect.addActionListener(cmd.aType);
        JMenuItem oval = new JMenuItem("Oval");
        oval.setActionCommand("oval");
		oval.addActionListener(cmd.aType);
        JMenuItem Rrect = new JMenuItem("RoundRect");
        Rrect.setActionCommand("Rrect");
		Rrect.addActionListener(cmd.aType);
        type.add(curve);
        type.add(line);
        type.add(rect);
        type.add(oval);
        type.add(Rrect);
        
        JMenuItem w1 = new JMenuItem("1px");
        w1.setActionCommand("bt1");
		w1.addActionListener(cmd.aWidth);
        JMenuItem w2 = new JMenuItem("2px");
        w2.setActionCommand("bt2");
		w2.addActionListener(cmd.aWidth);
        JMenuItem w4 = new JMenuItem("4px");
        w4.setActionCommand("bt4");
		w4.addActionListener(cmd.aWidth);
        width.add(w1);
        width.add(w2);
        width.add(w4);
	}
}

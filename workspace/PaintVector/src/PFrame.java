import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class PFrame extends JFrame
{
	PCommand cmd = PCommand.getInstance();
	
	PFrame()
	{
		setLayout(null);
		setBounds(30,30,900,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(PPanel.getInstance());
		
		JMenuBar mBar = new JMenuBar();
		
	    setJMenuBar(mBar);
	    
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
               
    
        JToolBar tb = new JToolBar();
        JButton r = new JButton(new ImageIcon("E:\\eclipse\\libVP\\red.png"));
        r.setActionCommand("red");
		r.addActionListener(cmd.aColor);
        JButton g = new JButton(new ImageIcon("E:\\eclipse\\libVP\\green.png"));
        g.setActionCommand("green");
		g.addActionListener(cmd.aColor);
        JButton b = new JButton(new ImageIcon("E:\\eclipse\\libVP\\blue.png"));
        b.setActionCommand("blue");
		b.addActionListener(cmd.aColor);
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
        tb.setBounds(0, 0, 485, 35);
        add(tb);
        
        JButton saveBtn = new JButton("SAVE");
		saveBtn.addActionListener(PCommand.getInstance().aSave);
		saveBtn.setBounds(10, 560, 120, 20);
		add(saveBtn);
		JButton loadBtn = new JButton("LOAD");
		loadBtn.addActionListener(PCommand.getInstance().aLoad);
		loadBtn.setBounds(10, 590, 120, 20);
		add(loadBtn);
        
        setVisible(true);
	}
}

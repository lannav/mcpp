
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PDraw extends JPanel implements MouseListener, MouseMotionListener
{
	ArrayList<PShape> pp = new ArrayList<PShape>();
	BufferedImage bi = null;
	PShape shape;
	int x,y;
	PData data = PData.getInstance();
	private static PDraw instance = null;
	PCommand cmd = PCommand.getInstance();
	
	public PDraw()
	{
		setBounds(150,10,760,520);
		setBackground(Color.WHITE);
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		 JMenu color = new JMenu("Color");
	       
	     JMenu type = new JMenu("Type");
	        
	     JMenu width = new JMenu("Width");
	        
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
		
		JPopupMenu popup = new JPopupMenu();
        popup.add(color);
        popup.add(type);
        popup.add(width);
        class PopupClass extends MouseAdapter
        {
            public void mousePressed(MouseEvent event)
            {
            	openMenu(event);
            }

            public void mouseReleased(MouseEvent event)
            {
            	openMenu(event);
            }

            private void openMenu(MouseEvent event)
            {
                if (event.isPopupTrigger())
                {
                	popup.show(event.getComponent(),
                    		event.getX(), event.getY());
                }
            }
        }
        addMouseListener(new PopupClass());
		
	}
	
	public static PDraw getInstance()
	{
		if(instance == null)
			instance = new PDraw();
		
		return instance;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		if ((arg0.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK)) return;
		
			if(data.type == "curve")
			{
			int x2 = arg0.getX();
			int y2 = arg0.getY();
			shape = new PCurve(x,y,x2,y2,data.clr,data.width);
			pp.add(shape);
			x = x2;
			y = y2;
			repaint();
			}
	}
	
	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
		Graphics2D gg = (Graphics2D) arg0;
		if(bi != null)
			gg.drawImage(bi,0,0,null);
		for(PShape shape:pp)
			shape.draw(gg);
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		if(arg0.getButton()==MouseEvent.BUTTON1)
		{
		x = arg0.getX();
		y = arg0.getY();
		}
	}


	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		if(arg0.getButton()==MouseEvent.BUTTON1)
		{
			int x2 = arg0.getX();
			int y2 = arg0.getY();
			
			if(x2 < x)
			{
				int tmp = x;
				x = x2;
				x2 = tmp;
			}
			if(y2 < y)
			{
				int tmp = y;
				y = y2;
				y2 = tmp;
			}
			
			switch(data.type)
			{
			case "line"  : shape = new PLine(x,y,x2,y2,data.clr,data.width);      break;
			case "rect"  : shape = new PRect(x,y,x2,y2,data.clr,data.width);      break;
			case "Rrect" : shape = new PRoundRect(x,y,x2,y2,data.clr,data.width); break;
			case "oval"  : shape = new POval(x,y,x2,y2,data.clr,data.width);      break;
			}
			pp.add(shape);
			repaint();	
		}
	}
}

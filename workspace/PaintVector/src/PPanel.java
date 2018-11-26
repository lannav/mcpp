import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class PPanel extends JPanel 
{
	private static PPanel instance = null;
    JColorChooser cc;  
	
	private PPanel()
	{
		PType type   = new PType();
		PWidth width = new PWidth();
		PColor color = new PColor();
		PDraw pdr = PDraw.getInstance();
		
		setBounds(10,40,760,510);
		setLayout(null);
		type.setBounds(10, 10, 140, 160);
		type.setBackground(Color.cyan);
		add(type);
		width.setBounds(10, 180, 140, 100);
		width.setBackground(Color.magenta);
		add(width);
		color.setBounds(10, 290, 140, 100);
		color.setBackground(Color.yellow);
		add(color);
		add(pdr);
		cc = new JColorChooser(Color.black);
		cc.setBounds(10, 400, 140, 200);
		cc.getSelectionModel().addChangeListener(PCommand.getInstance().aCList);
		AbstractColorChooserPanel[] ppc = cc.getChooserPanels();
		cc.removeChooserPanel(ppc[1]);
		cc.removeChooserPanel(ppc[2]);
		cc.removeChooserPanel(ppc[3]);
		cc.removeChooserPanel(ppc[4]);
		add(cc);
	}
	
	public static PPanel getInstance()
	{
		if(instance == null)
			instance = new PPanel();
		
		return instance;
	}
}

package BsTreePainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PPanel extends JPanel
{
	public PPanel()
	{
		JButton btn = new JButton("Draw Tree");
		
		btn.addActionListener(new ActionDraw());
		
		setLayout(null);
		btn.setBounds(10, 10, 120, 20);
		add(btn);
	}
	
	class ActionDraw implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
        {
        	TrDraw tr = new TrDraw(); 
        	int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
    		tr.init(ini);
        	tr.draw(PPanel.this);
        }
   }
	
}


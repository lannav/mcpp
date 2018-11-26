import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AVLTreeTest 
{
	/*public static void main(String[] args)
	{
		new (class PFrame extends JFrame
		{
			
			PFrame()
			{
				setBounds(100,100,900,600);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				add(new PPanel());
				setVisible(true);
			}
		});
	}*/
	
	class PPanel extends JPanel
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
	        	AVLtree tr = new AVLtree(); 
	        	int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
	    		tr.init(ini);
	        	tr.draw(PPanel.this);
	        }
	   }	
	}
}
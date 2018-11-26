import java.awt.Color;
import java.awt.Component;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

public class AFrame extends JFrame
{
	private ArrayList<AdaptiveComponent> pp;
	ChengedBoundsListener kpp = new ChengedBoundsListener();
	
	public AFrame()
	{
		pp = new ArrayList<AdaptiveComponent>();
		
		APanel1 pan = new APanel1();
		AButtonPanel pan1 = new AButtonPanel();
		setLayout(null);
		setBounds(50, 50, 830, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.green);
	//	setContentPane(new JPanel());
	//  JLayeredPane	
		subscribe(pan);
		getContentPane().addHierarchyBoundsListener(kpp);
		
		add(pan);

		setVisible(true);
	}
	
	private void subscribe(AdaptiveComponent a)
	{
		pp.add(a);
	}
	
	class ChengedBoundsListener implements HierarchyBoundsListener
	{

		@Override
		public void ancestorResized(HierarchyEvent arg0) 
		{
			Component chenged = arg0.getChanged();
			if(chenged.getClass().getSimpleName().equals("JLayeredPane"))
			{
				int width = chenged.getWidth();
				int height = chenged.getHeight();
				
				for(AdaptiveComponent p : pp)
					p.changedBounds(width, height);
				
				
			}
		}
		
		@Override
		public void ancestorMoved(HierarchyEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}

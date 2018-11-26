import java.awt.Color;
import java.awt.Component;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class APanel1 extends JPanel implements AdaptiveComponent
{
	private ArrayList<AdaptiveComponent> pp;
	ChengedBoundsListener kpp = new ChengedBoundsListener();
	
	public APanel1()
	{
		pp = new ArrayList<AdaptiveComponent>();
		
		APanel pan = new APanel();
		AButtonPanel pan1 = new AButtonPanel();
		setLayout(null);
		setBounds(10, 10, 800, 600);
		setBackground(Color.ORANGE);
	//	setContentPane(new JPanel());
	//  JLayeredPane	
		subscribe(pan);
		subscribe(pan1);
		addHierarchyBoundsListener(kpp);
		
		add(pan);
		add(pan1);

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

	@Override
	public void changedBounds(int width, int height) 
	{
		float left = 0.01f*(float)width,
				  top = (float)height*0.01f,
				  myWidth = (float)width/820f * 800f,
				  myHeight = (float)height/640f * 600f;
			
			setBounds((int)left, (int)top, (int)myWidth, (int)myHeight);
	}
}

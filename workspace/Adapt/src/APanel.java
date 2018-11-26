import java.awt.Color;

import javax.swing.JPanel;

public class APanel extends JPanel implements AdaptiveComponent
{

	public APanel()
	{
		setBackground(Color.RED);
		setBounds(10, 10, 500, 500);
	}
	
	@Override
	public void changedBounds(int width, int height) 
	{
		float left = 0.01f*(float)width,
			  top = (float)height*0.01f,
			  myWidth = (float)width/790f * 500f,
			  myHeight = (float)height/590f * 500f;
		
		setBounds((int)left, (int)top, (int)myWidth, (int)myHeight);
	}

}

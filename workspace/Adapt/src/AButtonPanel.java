import java.awt.Color;

import javax.swing.JPanel;

public class AButtonPanel extends JPanel implements AdaptiveComponent
{

	public AButtonPanel()
	{
		setBackground(Color.blue);
		setBounds(520, 10, 270, 500);
	}
	@Override
	public void changedBounds(int width, int height) 
	{
		float left = 0.02f*(float)width + (float)width/790f * 500f,
			  top = (float)height*0.01f,
			  myWidth = (float)width/790f * 270f,
			  myHeight = (float)height/590f * 500f;
		
		setBounds((int)left, (int)top, (int)myWidth, (int)myHeight);
	}

}

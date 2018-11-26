package View;
import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public static PFrame instance = null;
	PFrame()
	{
		setTitle("Person list");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PPanel());
		setVisible(true);
	}
	public static PFrame getInstance()
	{
		if(instance == null)
			instance = new PFrame();
		
		return instance;
	}
}

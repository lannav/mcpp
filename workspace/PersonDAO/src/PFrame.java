import javax.swing.JFrame;

public class PFrame extends JFrame
{
	PFrame()
	{
		setTitle("Person list");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PPanel());
		setVisible(true);
	}
}

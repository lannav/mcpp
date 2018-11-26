import javax.swing.JFrame;

public class BFrame extends JFrame
{
	BFrame()
	{
		BPanel panel = new BPanel();
		setTitle("Bubble");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(400, 200, 800, 600);
		add(panel);
		setVisible(true);
	}
}
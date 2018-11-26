import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CPanel extends JPanel 
{
	JLabel output;
	
	public CPanel()
	{
		setLayout(null);
		setBounds(0,0,390,265);
		setBackground(new Color(28, 28, 28));
		
		output = new JLabel();
		output.setHorizontalAlignment(JTextField.RIGHT);
		output.setBounds(5, 5, 230, 30);
		output.setBackground(new Color(28, 28, 28));
		output.setBorder(null);
		output.setForeground(Color.WHITE);
		output.setFont(new Font("Colibri",Font.BOLD,30));
		output.setText("0");
		add(output);
		CLogic cl = new CLogic(output,this);
		add(new ButtonPanel(cl));
		addKeyListener(cl.kl);
		setFocusable(true);
        requestFocusInWindow();
	}
}

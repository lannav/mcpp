import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CLogic 
{
	ArrayList<String> digits = new ArrayList<String>();
	ArrayList<String> operations = new ArrayList<String>();
	String operation = "0";
	String ch1;
	KeyList kl = new KeyList();
	ActionOper ao = new ActionOper();
	JLabel output;
	CPanel cp;
	
	public CLogic(JLabel output,CPanel cp)
	{
		this.cp = cp;
		this.output = output;
		String[] mas = {"0","1","2","3","4","5","6","7","8","9",".","/","*","-","+"};
		for(int i = 0; i < mas.length; i++)
		{
			if(i < 11)
				digits.add(mas[i]);
			else
				operations.add(mas[i]);
		}
	}
	
	class KeyList implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) 
		{
			switch(e.getKeyChar()+"")
			{
			case "0" : ButtonPanel.zero.doClick(); break;
			case "1" : ButtonPanel.one.doClick(); break;
			case "2" : ButtonPanel.two.doClick(); break;
			case "3" : ButtonPanel.three.doClick(); break;
			case "4" : ButtonPanel.four.doClick(); break;
			case "5" : ButtonPanel.five.doClick(); break;
			case "6" : ButtonPanel.six.doClick(); break;
			case "7" : ButtonPanel.seven.doClick(); break;
			case "8" : ButtonPanel.eight.doClick(); break;
			case "9" : ButtonPanel.nine.doClick(); break;
			case "+" : ButtonPanel.plus.doClick(); break;
			case "-" : ButtonPanel.minus.doClick(); break;
			case "/" : ButtonPanel.div.doClick(); break;
			case "*" : ButtonPanel.inc.doClick(); break;
			case "\n" : ButtonPanel.result.doClick(); break;
			case "." : ButtonPanel.point.doClick(); break;
			case "%" : ButtonPanel.per.doClick(); break;
			}
			
			if(e.getKeyChar() == '\b')
				if(output.getText().length() == 1)
					output.setText("0");
				else
					output.setText(output.getText().substring(0, output.getText().length()-1));
		}

		@Override
		public void keyPressed(KeyEvent e) {
		
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		
			
		}
		
	}

	class ActionOper implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String cha = e.getActionCommand();
			
			if(output.getText().length() >= 13 && cha != "=" && !operations.contains(cha))
				return;
			
			if (digits.contains(cha))
			{
				if(cha == "." && output.getText().contains("."))
					return;
				if(output.getText() == "0")
				{
					output.setText(cha+"");
					return;
				}
				output.setText(output.getText() + cha);
			}
			
			if (operations.contains(cha))
			{
				operation = cha;
				setColor();
				ch1 = output.getText();
				output.setText("0");
			}
			
			if(e.getActionCommand() == "=" && operation != "0")
			{
				sendRequest();
				ch1 = "";
			}
			
			if(e.getActionCommand() == "AC")
			{
				output.setText("0");
				ch1 = "";
				operation = "0";
				setColor();
			}
			
			if(e.getActionCommand() == "+/-")
				if(output.getText().contains("-"))
					output.setText(output.getText().replace("-", ""));
				else
					output.setText("-" + output.getText());
			cp.requestFocusInWindow();
		}
		
	}

	public void sendRequest() {
		try {
			URL obj = new URL("https://peculiar.top//calcJava.php?ch1="+ch1+"&ch2="+output.getText()+"&op="+operation);
			operation = "0";
			setColor();
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			DocumentBuilder infoWriter = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document info = infoWriter.parse(con.getInputStream());
			Node root = info.getDocumentElement();
			Node result = root.getFirstChild();
			String answer = "";
			if(!result.getTextContent().equals("div 0"))
			{
				BigDecimal res = new BigDecimal(result.getTextContent());
				String xz = res.setScale(0,BigDecimal.ROUND_HALF_UP).toString();
				answer = res.setScale(13-xz.length(),BigDecimal.ROUND_HALF_UP).toString();
			}else
				answer = "div 0";
			
			output.setText(answer);	
		} catch (IOException | ParserConfigurationException | SAXException e) {
		}
	}
	
	private void setColor()
	{
		Color orange = new Color(238, 154, 0);
		Color active = new Color(230, 230, 230);
		
		switch(operation)
		{
		case "+" : ButtonPanel.plus.setBackground(active);
					ButtonPanel.plus.setForeground(orange);
					break;
		case "-" : ButtonPanel.minus.setBackground(active);
					ButtonPanel.minus.setForeground(orange);
					break;
		case "/" : ButtonPanel.div.setBackground(active);
					ButtonPanel.div.setForeground(orange);
					break;
		case "*" : ButtonPanel.inc.setBackground(active);
					ButtonPanel.inc.setForeground(orange);
					break;
		case "0" : ButtonPanel.plus.setBackground(orange);
					ButtonPanel.plus.setForeground(Color.WHITE);
					ButtonPanel.minus.setBackground(orange);
					ButtonPanel.minus.setForeground(Color.WHITE);
					ButtonPanel.div.setBackground(orange);
					ButtonPanel.div.setForeground(Color.WHITE);
					ButtonPanel.inc.setBackground(orange);
					ButtonPanel.inc.setForeground(Color.WHITE);
					break;
		}
	}
}

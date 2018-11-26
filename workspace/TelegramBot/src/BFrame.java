import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BFrame extends JFrame
{
	public BFrame()
	{
		setTitle("BigBot handler");
		setBounds(600,150,273,390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ApiContextInitializer.init();
		TelegramBotsApi botapi = new TelegramBotsApi();
		try {
			botapi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		repaint();
		setVisible(true);
	}
	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
		Graphics2D gg = (Graphics2D) arg0;
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(this.getClass().getResource("img.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gg.drawImage(bi,0,20,null);
	}
}
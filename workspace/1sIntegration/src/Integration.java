import java.io.IOException;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Integration extends TelegramLongPollingBot
{
//	public Integration() throws IOException
//	{
//		Runtime.getRuntime().exec("\"C:\\Program Files\\1cv8\\8.3.12.1529\\bin\\1cv8.exe\" /IBName \"»нформационна€ база\" /Execute \"E:\\¬нешн€€ќбработка1.epf\"");
//	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onUpdateReceived(Update e) 
	{
		if(!e.getMessage().getText().isEmpty())
			try {
				Runtime.getRuntime().exec("\"C:\\Program Files\\1cv8\\8.3.12.1529\\bin\\1cv8.exe\" /IBName \"»нформационна€ база\" /Execute \"E:\\¬нешн€€ќбработка1.epf\"");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return null;
	}
}

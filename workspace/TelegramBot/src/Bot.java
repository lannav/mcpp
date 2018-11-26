import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Contact;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Bot extends TelegramLongPollingBot
{	
	class Command
	{
		String com;
		boolean processed = false;		
		public Command(String com)
		{
			this.com = com;
		}
	}
	
	class Temp
	{
		long UserID;
		String fname = "";
		String lname = "";
		Location loc = null;
		Contact con = null;
		Message msg = null;
		boolean geocon = false;
		boolean location = false;
		boolean tomorrow = false;
		String file;
		ArrayList<Command> commands = new ArrayList<Command>();
	}
	
	private Temp getTmp(Long user)
	{
		for(Temp t:list)
		{
			if(t.UserID == user)
				return t;
		}
			Temp t = new Temp();
			t.UserID = user;
			list.add(t);
			return t;
	}
	
	ArrayList<Temp> list = new ArrayList<Temp>();
	Temp tmp = null;
	
	@Override
	public String getBotUsername() 
	{
		return "peculiar_bot";
	}

//	public void run1s()
//	{
//		try {
//			Runtime.getRuntime().exec("\"C:\\Program Files\\1cv8\\8.3.12.1529\\bin\\1cv8.exe\" /IBName \"Информационная база\" /Execute \"E:\\ВнешняяОбработка1.epf\"");
//			Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\Новая папка\\BigBot.exe");
//			System.exit(0);
//		} catch (IOException e1) {
//			
//			e1.printStackTrace();
//		}
//	}
	
	@Override
	public void onUpdateReceived(Update e)
	{
		//////////////////////////////////////////////////////////
//		if(!e.getMessage().getText().isEmpty())
//				run1s();
			
		//////////////////////////////////////////////////////////
		tmp = getTmp(e.getMessage().getChatId());
		tmp.msg = e.getMessage();
		if(tmp.msg.getLocation() == null && tmp.msg.getContact() == null && tmp.msg.getText() == null || tmp.msg.getText() == "")
		{
			sendMsg(tmp.msg.getChatId(), ansUnknown());
			return;
		}
		if(tmp.fname.isEmpty())
		{
			tmp.fname = tmp.msg.getFrom().getFirstName();
			tmp.lname = tmp.msg.getFrom().getLastName();
		}
		String chatID = tmp.msg.getChatId()+"";
		tmp.file = "F:\\BotChats\\chatID"+chatID+".xml";
		String txt = tmp.msg.getText();
		writeMsgToXml("USER",txt);
		tmp.commands.add(new Command(txt));
		if(tmp.msg.getLocation() != null)
		{
			tmp.loc = tmp.msg.getLocation();
			writeUserLoc(tmp.msg);
			writeMsgToXml("USER","Пользователь прислал геопозицию");
			if(tmp.location || tmp.tomorrow)
			{
				boolean temp = tmp.tomorrow;
				tmp.location = false;
				tmp.tomorrow = false;
				sendMsg(tmp.msg.getChatId(),ansWtLocation(temp));
				return;
			}
		}
		if(tmp.msg.getContact() != null)
		{
			tmp.con = tmp.msg.getContact();
			writeMsgToXml("USER","Пользователь прислал контакт "+tmp.msg.getContact().getFirstName()+" "+tmp.msg.getContact().getLastName());
			if(tmp.geocon)
			{
			sendLoc(tmp.msg.getChatId());
			tmp.geocon = false;
			}
			return;
		}
		switch(txt)
		{
		case "/start"   : sendMsg(tmp.msg.getChatId(), ansStart()); break;
		case "/wt"      : sendMsg(tmp.msg.getChatId(), ansWt()); break;
		case "/home"    : sendMsg(tmp.msg.getChatId(), ansHome()); break;
		case "/help"    : if(tmp.UserID == 601754293)
			sendMsg(tmp.msg.getChatId(), ansHelp()+"\n/balance узнать сколько осталось денег");
		else
			sendMsg(tmp.msg.getChatId(), ansHelp()); 
			break;
		case "/dnipro"  : sendMsg(tmp.msg.getChatId(), ansWtDnipro(tmp.msg)); break;
		case "/location": tmp.location = true; sendMsg(tmp.msg.getChatId(), ansWtLocation(false)); break;
		case "/geocon"  : tmp.geocon = true; sendMsg(tmp.msg.getChatId(), "Пришлите в чат интересующий вас контакт"); break;
		case "/holiday" : sendMsg(tmp.msg.getChatId(), ansHoliday()); break;
		case "/tomorrow": tmp.tomorrow = true; sendMsg(tmp.msg.getChatId(), ansWtLocation(true)); break;
		case "/balance" : if(tmp.UserID == 601754293)
			sendMsg(tmp.msg.getChatId(), "осталось 1800грн"); break;
		default         : sendMsg(tmp.msg.getChatId(), ansUnknown()); break;
		}
	}
	
	private String ansHoliday() 
	{
		String url = "http://www.calend.ru/img/export/today-holidays.rss";
		String result = "";
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(con.getInputStream());
			Node root = document.getDocumentElement();
	        NodeList node = root.getChildNodes();
	        NodeList nodes = node.item(1).getChildNodes();
	        for (int i = 0; i < nodes.getLength(); i++) 
	            {
	                if(nodes.item(i).getNodeName().equals("item"))
	                {
	                	if(nodes.item(i).getFirstChild().getTextContent().substring(0, 2).contains((new Date()).getDate()+""))
	                	{
	                		result += nodes.item(i).getFirstChild().getTextContent();
	                		NodeList tmp = nodes.item(i).getChildNodes();
	                		result += " ("+tmp.item(4).getTextContent()+")\n";
	                	}
	                }
	            }
			result = result.substring(0, result.length()-1);
			}catch (IOException | ParserConfigurationException | SAXException e) {
				e.printStackTrace();
			}
		return result;
	}

	private String ansStart() 
	{
		return "Вас приветствует БигБот!\n"
				+ "Если хотите узнать что я умею жмите /help.";
	}
	
	private String ansHelp() 
	{
		return "/wt узнать погоду\n"
				   /*+ "/home узнать кто есть дома\n"*/
				   + "/geocon узнать последнее местоположение контакта\n"
				   + "/holiday какой сегодня праздник";
	}

	private String ansUnknown() 
	{
		return "Неизвесный запрос.\n"
				+ "/help - получить список доступных команд.";
	}

	private String ansHome() 
	{
		return "Дома Женя, Боря, Таня и Лариса";
	}
	
	private String ansWt() 
	{
		return "Узнать погоду в Днепре /dnipro\n"
				+ "Или по местоположению /location\n"
				+ "Узнать погоду на завтра /tomorrow";
	}

	private String ansWtDnipro(Message msg)
	{
		String url = "https://api.openweathermap.org/data/2.5/weather?id=709930&units=metric&APPID=9684b9769556fd57c1be4f458af9e850";
		String temp = "";
		String pressure = "";
		String humidity = "";
		String speed = "";
		String deg = "";
		String name = "";
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
			name = jsonObj.get("name").getAsString();
			JsonObject main = jsonObj.get("main").getAsJsonObject();
			temp = main.get("temp").getAsBigDecimal().setScale(0,BigDecimal.ROUND_HALF_UP).toString();
			pressure = new BigDecimal(main.get("pressure").getAsDouble()/1.33322).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
			humidity = main.get("humidity").getAsString();
			JsonObject wind = jsonObj.get("wind").getAsJsonObject();
			speed = wind.get("speed").getAsString();
			int degg = wind.get("deg").getAsInt();
			if(degg > 0 && degg < 22.5 || degg > 337.5 && degg < 361)
				deg = "Северный";
			if(degg > 22.5 && degg < 67.5)
				deg = "Северо-Восточный";
			if(degg > 67.5 && degg < 112.5)
				deg = "Восточный";
			if(degg > 112.5 && degg < 157.5)
				deg = "Юго-Восточный";
			if(degg > 157.5 && degg < 202.5)
				deg = "Южный";
			if(degg > 202.5 && degg < 247.5)
				deg = "Юго-Западный";
			if(degg > 247.5 && degg < 292.5)
				deg = "Западный";
			if(degg > 292.5 && degg < 337.5)
				deg = "Северо-Западный";
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Местоположение: " + name + "\n"
				+ "Температура: " + temp + "℃\n"
				+ "Давление: " + pressure + "мм.рт.ст\n"
				+ "Влажность: " + humidity + "%\n"
				+ "Порывы ветра: до  " + speed + "м/с\n"
				+ "Ветер: " + deg;
	}

	private String ansWtLocation(boolean tomorrow)
	{
		String cord = "";
		String[] loc = requestLocationFromXml(tmp.msg.getChatId());
		long dateFromXml = 0;
		
		if(loc != null)	
			dateFromXml = Long.parseLong(loc[2]);
		
		long currentDate = System.currentTimeMillis();
	    if(currentDate - dateFromXml <= 900000)
	    	cord = "lat="+loc[0]+"&lon="+loc[1];
	    else
	    {
	    	sendLocationRequest();
	    	return "Ваше местоположение неизвесно";
	    }
	    
		String when = "";
		String mode = "";
		if(tomorrow)
		{
			when = "forecast";
			mode = "type=like&";
		}
		else
			when = "weather";
		
		String url = "https://api.openweathermap.org/data/2.5/"+when+"?"+cord+
				"&units=metric&"+mode+"mode=xml&APPID=9684b9769556fd57c1be4f458af9e850";
		String temp = "";
		String pressure = "";
		String humidity = "";
		String speed = "";
		String deg = "";
		String name = "";
		int degg = 0;
		double tempMax = 0;
		double tempMin = 0;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
//			BufferedReader in = new BufferedReader(
//			        new InputStreamReader(con.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
			
//			JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
//			name = jsonObj.get("name").getAsString();
//			JsonObject main = jsonObj.get("main").getAsJsonObject();
//			temp = main.get("temp").getAsBigDecimal().setScale(0,BigDecimal.ROUND_HALF_UP).toString();
//			pressure = new BigDecimal(main.get("pressure").getAsDouble()/1.33322).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
//			humidity = main.get("humidity").getAsString();
//			JsonObject wind = jsonObj.get("wind").getAsJsonObject();
//			speed = wind.get("speed").getAsString();
//			int degg = wind.get("deg").getAsInt();
			DocumentBuilder infoWriter = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document info = infoWriter.parse(con.getInputStream());
			Node root = info.getDocumentElement();
			NodeList users = root.getChildNodes();
				if(!tomorrow)
				{
					name = users.item(0).getAttributes().getNamedItem("name").getNodeValue();
					temp = new BigDecimal(users.item(1).getAttributes().getNamedItem("value").getNodeValue()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					humidity = new BigDecimal(users.item(2).getAttributes().getNamedItem("value").getNodeValue()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					pressure = new BigDecimal(Double.parseDouble(users.item(3).getAttributes().getNamedItem("value").getNodeValue()) / 1.33322).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					NodeList wind = users.item(4).getChildNodes();
					speed = new BigDecimal(wind.item(0).getAttributes().getNamedItem("value").getNodeValue()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					degg = new BigDecimal(Double.parseDouble(wind.item(2).getAttributes().getNamedItem("value").getNodeValue())).setScale(0,BigDecimal.ROUND_HALF_UP).toBigInteger().intValue();
					
					if(degg > 0 && degg < 22.5 || degg > 337.5 && degg < 361)
						deg = "Северный";
					if(degg > 22.5 && degg < 67.5)
						deg = "Северо-Восточный";
					if(degg > 67.5 && degg < 112.5)
						deg = "Восточный";
					if(degg > 112.5 && degg < 157.5)
						deg = "Юго-Восточный";
					if(degg > 157.5 && degg < 202.5)
						deg = "Южный";
					if(degg > 202.5 && degg < 247.5)
						deg = "Юго-Западный";
					if(degg > 247.5 && degg < 292.5)
						deg = "Западный";
					if(degg > 292.5 && degg < 337.5)
						deg = "Северо-Западный";
				}else
				{
					double dayTemp = 0;
					double dayPressure = 0;
					double dayHumidity = 0;
					double daySpeed = 0;
					name = users.item(0).getFirstChild().getTextContent();
					NodeList forecast = users.item(4).getChildNodes();
					for(int i = 0; i < forecast.getLength(); i++)
					{
						NodeList current = forecast.item(i).getChildNodes();
						if(i == 0)
						{
							tempMax = Double.parseDouble(current.item(4).getAttributes().getNamedItem("max").getNodeValue());
							tempMin = Double.parseDouble(current.item(4).getAttributes().getNamedItem("min").getNodeValue());
						}
						if(tempMax < Double.parseDouble(current.item(4).getAttributes().getNamedItem("max").getNodeValue()))
							tempMax = Double.parseDouble(current.item(4).getAttributes().getNamedItem("max").getNodeValue());
						
						if(tempMin > Double.parseDouble(current.item(4).getAttributes().getNamedItem("min").getNodeValue()))
							tempMin = Double.parseDouble(current.item(4).getAttributes().getNamedItem("min").getNodeValue());
						
						daySpeed += Double.parseDouble(current.item(3).getAttributes().getNamedItem("mps").getNodeValue());
						dayTemp += Double.parseDouble(current.item(4).getAttributes().getNamedItem("value").getNodeValue());
						dayPressure += Double.parseDouble(current.item(5).getAttributes().getNamedItem("value").getNodeValue());
						dayHumidity += Double.parseDouble(current.item(6).getAttributes().getNamedItem("value").getNodeValue());
					}
					speed = new BigDecimal(daySpeed / forecast.getLength()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					temp = new BigDecimal(dayTemp / forecast.getLength()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					pressure = new BigDecimal(dayPressure / forecast.getLength() / 1.33322).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
					humidity = new BigDecimal(dayHumidity / forecast.getLength()).setScale(0,BigDecimal.ROUND_HALF_UP).toString();
				}
			
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		String choise = "";
		if(!tomorrow)
			choise = "Температура: " + temp + "℃\n";
		else
			choise = "Максимальная температура: " + new BigDecimal(tempMax).setScale(0,BigDecimal.ROUND_HALF_UP).toString() + "℃\n"+
					"Температура среднесуточная: " + temp + "℃\n"+
					"Минимальная температура: " + new BigDecimal(tempMin).setScale(0,BigDecimal.ROUND_HALF_UP).toString() + "℃\n";
		String result = "Местоположение: " + name + "\n"
				+ choise
				+ "Давление: " + pressure + " мм.рт.ст\n"
				+ "Влажность: " + humidity + " %\n"
				+ "Порывы ветра: до " + speed + " м/с";
		
		if(!tomorrow)
			result += "\nВетер: " + deg; 
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	private void sendLocationRequest() 
	{
		SendMessage s = new SendMessage();
		s.setChatId(tmp.msg.getChatId());
		ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
		ArrayList<KeyboardRow> list = new ArrayList<KeyboardRow>(); 
		KeyboardRow kbr = new KeyboardRow();
		KeyboardButton kbt = new KeyboardButton("Предоставить местоположение");
		kbt.setRequestLocation(true);
		kbr.add(kbt);
		list.add(kbr);
		kb.setKeyboard(list);
		kb.setOneTimeKeyboard(true);
		s.setReplyMarkup(kb);
		s.setText("Предоставте ваше местоположение");
		try { //Чтобы не крашнулась программа при вылете Exception 
			sendMessage(s);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
		writeMsgToXml("BOT","Предоставте ваше местоположение");
	}

	@SuppressWarnings("deprecation")
	private void sendLoc(Long chatID) 
	{
		SendLocation s = new SendLocation();
		SendMessage mess = new SendMessage();
		mess.setChatId(chatID);
		s.setChatId(chatID);
		String[] location = requestLocationFromXml(chatID);
		if(location == null)
		{
			mess.setText("Невозможно получить местоположение");
		}else
		{
			Date d = new Date(Long.parseLong(location[2]));
			String date = d.toGMTString().replaceAll(" GMT", "");
			mess.setText("Местоположение получено " + date);
			s.setLatitude(Float.parseFloat(location[0]));
			s.setLongitude(Float.parseFloat(location[1]));
		}
		try { //Чтобы не крашнулась программа при вылете Exception 
			if(location != null)
				sendLocation(s);
			sendMessage(mess);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
	}

	private String[] requestLocationFromXml(long userID) 
	{
		String[] res = null;
		try {
			DocumentBuilder infoWriter = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document info = infoWriter.parse("F:\\BotChats\\usersInfo.xml");
			Node root = info.getDocumentElement();
			NodeList users = root.getChildNodes();
			String id = userID+"";
			for (int i = 0; i < users.getLength(); i++) 
            {
				NamedNodeMap nnm = users.item(i).getAttributes();
               if(id.equals(nnm.getNamedItem("userID").getNodeValue()))
               {
            	   res = new String[3];
            	   res[0] = nnm.getNamedItem("lastLat").getNodeValue();
            	   res[1] = nnm.getNamedItem("lastLon").getNodeValue();
            	   res[2] = nnm.getNamedItem("time").getNodeValue();
               }
            }
		} catch (ParserConfigurationException | SAXException | IOException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

	private void writeUserLoc(Message msg) 
	{
		try {
			DocumentBuilder infoWriter = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document info = infoWriter.parse("F:\\BotChats\\usersInfo.xml");
			Node root = info.getDocumentElement();
			NodeList users = root.getChildNodes();
			String id = msg.getFrom().getId()+"";
			boolean added = false;
			for (int i = 0; i < users.getLength(); i++) 
            {
				NamedNodeMap nnm = users.item(i).getAttributes();
               if(id.equals(nnm.getNamedItem("userID").getNodeValue()))
               {
            	   Location loc = msg.getLocation();
            	   nnm.getNamedItem("lastLat").setNodeValue(loc.getLatitude()+"");
            	   nnm.getNamedItem("lastLon").setNodeValue(loc.getLongitude()+"");
            	   nnm.getNamedItem("time").setNodeValue(System.currentTimeMillis()+"");
            	   added = true;
               }
            }
			if(!added)
			{
				Location loc = msg.getLocation();
				String fname = "";
				String lname = "";
				try {
					lname = tmp.msg.getFrom().getLastName().replaceAll("\\W+", "");
				}catch(Exception e)
				{
					
				}
				try {
					fname = tmp.msg.getFrom().getFirstName().replaceAll("\\W+", "");
				}catch(Exception e)
				{
					
				}
				Element user = info.createElement(fname+"_"+lname);
				user.setAttribute("userID", tmp.msg.getChatId()+"");
				user.setAttribute("lastLat", loc.getLatitude()+"");
				user.setAttribute("lastLon", loc.getLongitude()+"");
				user.setAttribute("time", System.currentTimeMillis()+"");
				root.appendChild(user);
			}
			Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(info);
            FileOutputStream fos = new FileOutputStream("F:\\BotChats\\usersInfo.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            fos.close();
			
		} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	private void writeMsgToXml(String writer, String txt)
	{
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = null;
			
			try {
				document = documentBuilder.parse(tmp.file);
			}catch(FileNotFoundException exception)
			{
				document = documentBuilder.getDOMImplementation().createDocument("", "F:\\BotChats\\chatID"+tmp.msg.getChatId()+".xml", null);
			}
			
            Node root = document.getDocumentElement();
            NodeList dates = root.getChildNodes();
            boolean added = false;
            Date currentDate = new Date();
            String curDate = currentDate.toGMTString().replaceAll(" \\d\\d:\\d\\d:\\d\\d GMT| ", "");
            String time = currentDate.toGMTString().replaceAll("[A-Za-z0-9 ]+\\d{4} | GMT", "");
            for (int i = 0; i < dates.getLength(); i++) 
            {
                if(dates.item(i).getNodeName().equals("MessagesBehind_"+curDate))
                {
                	added = true;
                	Element message = document.createElement("message");
                	message.setTextContent(txt);
                	message.setAttribute("time",time);
                	message.setAttribute("writer", writer);
                	dates.item(i).appendChild(message);
                	
                }
            }
            if(!added)
            {
            	Element date = document.createElement("MessagesBehind_"+curDate);
            	Element message = document.createElement("message");
            	message.setTextContent(txt);
            	message.setAttribute("time",time);
            	message.setAttribute("writer", writer);
            	date.appendChild(message);
            	root.appendChild(date);
            }
            
			
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(tmp.file);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            fos.close();
		} catch (IOException | ParserConfigurationException | SAXException | TransformerFactoryConfigurationError | TransformerException ex) 
		{
			ex.printStackTrace();
		}
	}

	@Override
	public String getBotToken() 
	{
		return "610274451:AAGxSRnQ3Hy_dBqLgDHa2t2kYLU3MdaP_pA";
	}
	
	@SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
	private void sendMsg(Long chatID, String text) {
		SendMessage s = new SendMessage();
		s.setChatId(chatID); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
		s.setText(text);
		if(!tmp.location && !tmp.tomorrow)
		s.setReplyMarkup(new ReplyKeyboardRemove());
		try { //Чтобы не крашнулась программа при вылете Exception 
			sendMessage(s);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
		writeMsgToXml("BOT",text);
	}

	/*this method not used 
	private void sendRequestFromOtherUser(Contact con, Message msg) 
	{
		sendLocationRequest(con.getUserID().longValue(), "Пользователь " + msg.getFrom().getFirstName() + " " + msg.getFrom().getLastName()
				+ " запрашивает ваше местоположение, если хотите предоставить нажмите 'Предоставить местоположение', если нет напишите в чат /no");
	}*/
}

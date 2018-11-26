import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyClass 
{
	public static void main(String[]args)
	{
		try {
	        // Создается построитель документа
	        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        // Создается дерево DOM документа из файла
	        Document document = documentBuilder.parse("E:\\eclipse\\PersonXML.xml");
	        // Получаем корневой элемент
	        Node root = document.getDocumentElement();
	     // Просматриваем все подэлементы корневого - т.е. персоны
	        NodeList persons = root.getChildNodes();
	        for (int i = 0; i < persons.getLength(); i++) 
	        {
	            Node person = persons.item(i);
	            // Если нода не текст, то это персона - заходим внутрь
	            if (person.getNodeType() != Node.TEXT_NODE) 
	            {
	                NodeList personData = person.getChildNodes();
	                int id = Integer.parseInt(personData.item(1).getTextContent());
	                String fname = personData.item(3).getTextContent();
	                String lname = personData.item(5).getTextContent();
	                int age = Integer.parseInt(personData.item(7).getTextContent());
	               System.out.println(id+","+fname+","+lname+","+age);
	            }
	        }
	    } catch (ParserConfigurationException ex) 
	    {
	        ex.printStackTrace(System.out);
	    } catch (SAXException ex) 
	    {
	        ex.printStackTrace(System.out);
	    } catch (IOException ex) 
	    {
	        ex.printStackTrace(System.out);
	    }
	}
}

package DAL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import blogic.Person;

public class PersonDAO_XML implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	@Override
	public void create(Person p)
	{
		try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("E:\\PersonData\\PersonXML.xml");
            // Получаем корневой элемент
            Node root = document.getDocumentElement();
         // Создаем новую персону по элементам
            // Сама персона <Person>
            Element person = document.createElement("person");
            // <id>
            Element id = document.createElement("id");
            // Устанавливаем значение текста внутри тега
            id.setTextContent(p.id+"");
            // <fname>
            Element fname = document.createElement("fname");
            fname.setTextContent(p.fname);
            // <lname>
            Element lname = document.createElement("lname");
            lname.setTextContent(p.lname);
            // <age>
            Element age = document.createElement("age");
            age.setTextContent(p.age+"");
            
            // Добавляем внутренние элементы персоны в элемент <person>
            person.appendChild(id);
            person.appendChild(fname);
            person.appendChild(lname);
            person.appendChild(age);
            // Добавляем персону в корневой элемент
            root.appendChild(person);
            
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("E:\\PersonData\\PersonXML.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            
        } catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (TransformerException e) 
		{
            e.printStackTrace(System.out);
        }
	}

	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("E:\\PersonData\\PersonXML.xml");
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
                    Person p = new Person(Integer.parseInt(personData.item(0).getTextContent()),personData.item(1).getTextContent(),personData.item(2).getTextContent(),Integer.parseInt(personData.item(3).getTextContent()));
                    pp.add(p);
                }
            }
            sort_id(pp);
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
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("E:\\PersonData\\PersonXML.xml");
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
                    if(Integer.parseInt(personData.item(0).getTextContent()) == p.id)
                    {
                    	personData.item(1).setTextContent(p.fname);
                    	personData.item(2).setTextContent(p.lname);
                    	personData.item(3).setTextContent(p.age+"");
                    }
                }
            }
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("E:\\PersonData\\PersonXML.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            
        } catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (TransformerException e) 
        {
            e.printStackTrace(System.out);
        }
	}

	@Override
	public void delete(Person p) 
	{
		try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("E:\\PersonData\\PersonXML.xml");
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
                    if(Integer.parseInt(personData.item(0).getTextContent()) == p.id)
                    	root.removeChild(person);
                }
            }
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("E:\\PersonData\\PersonXML.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            
        } catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (TransformerException e) 
        {
            e.printStackTrace(System.out);
        }
	}
	public static void sort_id(ArrayList<Person> pp)
	{
		Person temp = new Person();
		for(int i = pp.size() - 1; i > 0; i--)
			for(int j = 0; j < i; j++)
				if( pp.get(j).id > pp.get(j + 1).id)
				{
					temp = pp.get(j);
					pp.set(j, pp.get(j+1));
					pp.set(j+1, temp);
				}
	}
}

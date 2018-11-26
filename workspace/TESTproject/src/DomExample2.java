
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class DomExample2 {
 
    public static void main(String[] args) {
        try {
            // ��������� ����������� ���������
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // ��������� ������ DOM ��������� �� �����
            Document document = documentBuilder.parse("E:\\eclipse\\PersonXML.xml");
            // �������� �������� �������
            Node root = document.getDocumentElement();
         // ������������� ��� ����������� ��������� - �.�. �������
            NodeList persons = root.getChildNodes();
            for (int i = 0; i < persons.getLength(); i++) 
            {
                Node person = persons.item(i);
                // ���� ���� �� �����, �� ��� ������� - ������� ������
                if (person.getNodeType() != Node.TEXT_NODE) 
                {
                    NodeList personData = person.getChildNodes();
                    int id = Integer.parseInt(personData.item(0).getTextContent());
                    String fname = personData.item(1).getTextContent();
                    String lname = personData.item(2).getTextContent();
                    int age = Integer.parseInt(personData.item(3).getTextContent());
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
 
    // ������� ���������� ����� ����� � ������ ���������� � ����
    private static void addNewBook(Document document) throws TransformerFactoryConfigurationError, DOMException {
        // �������� �������� �������
        Node root = document.getDocumentElement();
 
        // ������� ����� ����� �� ���������
        // ���� ����� <Book>
        Element book = document.createElement("Book");
        // <Title>
        Element title = document.createElement("Title");
        // ������������� �������� ������ ������ ����
        title.setTextContent("Incredible book about Java");
        // <Author>
        Element author = document.createElement("Author");
        author.setTextContent("Saburov Anton");
        // <Date>
        Element date = document.createElement("Date");
        date.setTextContent("2015");
        // <ISBN>
        Element isbn = document.createElement("ISBN");
        isbn.setTextContent("0-06-999999-9");
        // <Publisher>
        Element publisher = document.createElement("Publisher");
        publisher.setTextContent("Java-Course publisher");
        // <Cost>
        Element cost = document.createElement("Cost");
        cost.setTextContent("499");
        // ������������� �������
        cost.setAttribute("currency", "RUB");
        
        // ��������� ���������� �������� ����� � ������� <Book>
        book.appendChild(title);
        book.appendChild(author);
        book.appendChild(date);
        book.appendChild(isbn);
        book.appendChild(publisher);
        book.appendChild(cost);
        // ��������� ����� � �������� �������
        root.appendChild(book);
        
        // ���������� XML � ����
        writeDocument(document);
    }
 
    // ������� ��� ���������� DOM � ����
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("other.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
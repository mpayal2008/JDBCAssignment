package XMLParse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParseRunner {
	final static Logger logger = LogManager.getLogger(XMLParseRunner.class);
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		InputStream xmlFile = XMLParseRunner.class.getClassLoader().getResourceAsStream("computer.xml");
		InputStream xsdFile = XMLParseRunner.class.getClassLoader().getResourceAsStream("computer.xsd");
		//to check if files are loaded
		if(xmlFile==null) {
			logger.info("Failed to load XML file.");
		}else{
			logger.info("file loaded");
		}
		
		if(xsdFile==null) {
			logger.info("Failed to load XSD file.");
		}else{
			logger.info("file loaded");
		}
		//calling method to validate xml file
		validationMethod(xmlFile, xsdFile);
				
		// To Parse XML file
		if(xmlFile==null) {
			logger.info("Failed to load XML file.");
		}else{
			logger.info("file loaded");
		}

        // Create a DocumentBuilder
        DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderfactory.newDocumentBuilder();

        // Parse the XML file
        Document document= builder.parse(xmlFile);
        
        //normalize xml structure
        document.getDocumentElement().normalize();
        
        //get all elements by tag name
        NodeList nodelist=  document.getElementsByTagName("computer");
      
        for (int i = 0; i < nodelist.getLength(); i++) {
        	
    	Node node= nodelist.item(i);
    		if(node.getNodeType()==Node.ELEMENT_NODE) {
    			Element element= (Element) node;
    			System.out.println("node "+element.getNodeName());
    			//get child element
    			NodeList nodeList1=node.getChildNodes();
    			
    			for(int j=0; j<nodeList1.getLength(); j++) {
    				Node node1=nodeList1.item(j);
    				Element childElement= (Element)nodeList1;
    				System.out.println(" "+childElement.getNodeName()+" "+childElement.getTagName()+" : "+childElement.getTextContent());
    			}
    		}
        }       
			}
	private static void validationMethod(InputStream xmlFile, InputStream xsdFile) throws SAXException {	       
		SchemaFactory schemafactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Source xmlSource= new StreamSource(xmlFile);
		Source xsdSource= new StreamSource(xsdFile);
 
		Schema schema1 = schemafactory.newSchema(xsdSource);
		Validator validator = schema1.newValidator();

		try {
			validator.validate(xmlSource);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	}  
}
}
	



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



public class XMLParser {
	final static Logger logger = LogManager.getLogger(XMLParser.class);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		//path of xml and xsd files
	String xmlFile="src/main/resources/computer.xml";
	String xsdFile="src/main/resources/computer.xsd";
	
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
	validateXMLnXSD(xmlFile, xsdFile);
	
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
	NodeList nodelist=  document.getElementsByTagName("*");
  
    for (int i = 0; i < nodelist.getLength(); i++) {
    	System.out.println(nodelist.getLength());
    	Node node= nodelist.item(i);
    		if(node.getNodeType()==Node.ELEMENT_NODE) {
    			Element rootNode= (Element) node;
    			System.out.println("root node "+rootNode.getNodeName());
    			//get child element
    			NodeList nodeList1=node.getChildNodes();
	
    			for(int j=0; j<nodeList1.getLength(); j++) {
    				Node node1=nodeList1.item(j);
    				Element childElement= (Element)nodeList1;
    				
    				
    				//System.out.println(childElement.getTextContent());
    				//System.out.println(" "+childElement.getNodeName()+" "+childElement.getTagName()+" : "+childElement.getTextContent());
    				//String tag= 
    				 String computer_id = childElement.getElementsByTagName("computer_id").item(j).getTextContent();
                     String internal_config_id = childElement.getElementsByTagName("internal_config_id").item(j).getTextContent();
                     String brand_name = childElement.getElementsByTagName("brand_name").item(j).getTextContent();
                     String model_name = childElement.getElementsByTagName("model_name").item(j).getTextContent();
                  
                  //   System.out.println("computer_id1 " + computer_id);
                     System.out.println(childElement.getNodeName());
                   //  System.out.println("computer_id " + computer_id);
                     //System.out.println("internal_config_id " + internal_config_id);
                    // System.out.println("brand_name " + brand_name);
                    // System.out.println("model_name: " + model_name);
                    
                     System.out.println("----------------------------");
    			}
    		}
    }        
}

   
  private static void validateXMLnXSD(String xmlFile, String xsdFile) throws SAXException {
	       
    SchemaFactory schemafactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema1 = schemafactory.newSchema(new File(xsdFile));
    Validator validator = schema1.newValidator();
    Source source = new StreamSource(new File(xmlFile));
    try {
		validator.validate(source);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
	}  
  }
}






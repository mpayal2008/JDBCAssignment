package xmlParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

public class XMlParseWithInputStream {
    final static Logger logger = LogManager.getLogger(XMlParseWithInputStream.class);
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        InputStream xml1 = XMlParseWithInputStream.class.getClassLoader().getResourceAsStream("computer2.xml");

        InputStream xsd1 = XMlParseWithInputStream.class.getClassLoader().getResourceAsStream("computer2.xsd");

        if (xml1 == null) {
            logger.info("Failed to load XML file.");
        } else {
            logger.info("xml file loaded");
        }

        if (xsd1 == null) {
            logger.info("Failed to load XSD file.");
        } else {
            logger.info(" xsd file loaded");
        }

        validationMethod(xml1,xsd1);

        InputStream xml2 = XMlParseWithInputStream.class.getClassLoader().getResourceAsStream("computer2.xml");

        // Create a DocumentBuilder
        DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderfactory.newDocumentBuilder();

        // Parse the XML file
        Document document= builder.parse(xml2);
        //normalize xml structure
        document.getDocumentElement().normalize();
        //to display xml file with node names
        displayXMLFile(document);
    }
    public static void validationMethod(InputStream xmlFile, InputStream xsdFile) {
        SchemaFactory schemafactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source xmlSource = new StreamSource(xmlFile);
        Source xsdSource = new StreamSource(xsdFile);

        try {
            Schema schema1 = schemafactory.newSchema(xsdSource);
            Validator validator = schema1.newValidator();
            validator.validate(xmlSource);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    private static void displayXMLFile(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node1= childNodes.item(i);
            if(node1.getNodeType()==Node.ELEMENT_NODE) {
                // displayXMLFile(node1);
                System.out.println(node1.getNodeName() +" : "+ node1.getTextContent()+"\n");
            }
        }
    }

}


/*
   InputStream xml2 = XMlParseWithInputStream.class.getClassLoader().getResourceAsStream("computer2.xml");

        // Create a DocumentBuilder
        DocumentBuilderFactory builderfactory;
        builderfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderfactory.newDocumentBuilder();

        // Parse the XML file
        Document document= builder.parse(xml2);

        //normalize xml structure
        document.getDocumentElement().normalize();
        NodeList nodelist= document.getElementsByTagName("computer");


        for (int i = 0; i < nodelist.getLength(); i++) {
            Node node = nodelist.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element rootNode = (Element) node;
                logger.info("root node " + rootNode.getNodeName());
                //get child element
                NodeList nodeList1 = node.getChildNodes();
                //	logger.info("child nodes "+node.getNodeName());
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    Node node1 = nodeList1.item(j);
                    Element childElement = (Element) nodeList1;

                    logger.info("node name is: "+ node1.getNodeName());
                    String brand_id = childElement.getElementsByTagName("brand_id").item(j).getTextContent();
                    String brand_name = childElement.getElementsByTagName("brand_name").item(j).getTextContent();
                    String item_names = childElement.getElementsByTagName("item_names").item(j).getTextContent();
                    String item_description = childElement.getElementsByTagName("item_description").item(j).getTextContent();
                    float item_price = Float.parseFloat(childElement.getElementsByTagName("item_price").item(j).getTextContent());

                    logger.info("brand_id " + brand_id);
                    logger.info("brand_name " + brand_name);
                    logger.info("item_names " + item_names);
                    logger.info("item_description: " + item_description);
                    logger.info("item_price: " + item_price);
                }
            }
        }
*/

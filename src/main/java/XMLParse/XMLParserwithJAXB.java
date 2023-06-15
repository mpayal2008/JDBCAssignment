package XMLParse;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.Accessories;

public class XMLParserwithJAXB {

	public static void main(String[] args) {
		 try {
	            JAXBContext jaxbContext = JAXBContext.newInstance(AccessoriesTable.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            AccessoriesTable table = (AccessoriesTable) jaxbUnmarshaller.unmarshal(new File("src/main/resources/computer2.xml"));

	            List<Accessories> accessories= table.getAccessories();
				
	            for (Accessories accessories2 : accessories) {
	                System.out.println("BrandID: " +accessories2.getBrandID());
	                System.out.println("BrandName: " + accessories2.getBrandName());
	                System.out.println("ItemName" + accessories2.getItemName());
	                System.out.println("ItemDescription" + accessories2.getItemDescription());
	                System.out.println("ItemPrice" + accessories2.getItemPrice());
	                System.out.println("---------------------------");
	            }
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
	    }

	}


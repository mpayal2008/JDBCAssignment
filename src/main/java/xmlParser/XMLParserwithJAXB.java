package xmlParser;


import models.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class XMLParserwithJAXB {
	private final static Logger logger = LogManager.getLogger(XMLParserwithJAXB.class);

	public static void main(String[] args) throws JAXBException {

		InputStream xml1 = XMlParseWithInputStream.class.getClassLoader().getResourceAsStream("computer2.xml");

		if (xml1 == null) {
			logger.info("Failed to load XML file.");
		} else {
			logger.info("xml file loaded");
		}
		JAXBContext jaxbContext1= JAXBContext.newInstance(ComputerData.class);
		Unmarshaller unmarshaller=jaxbContext1.createUnmarshaller();
		ComputerData comp1= (ComputerData) unmarshaller.unmarshal(xml1);



/* 		AccessoriesTable accessoriesTable = comp1.getAccessoriesTable();
		if (accessoriesTable != null) {
			List<Accessories> accessoriesList = accessoriesTable.getAccessories();
			for (Accessories accessories : accessoriesList) {
				logger.info(" Brand_id: " + accessories.getBrand_id());
				logger.info("Brand Name: " + accessories.getBrand_name());
				logger.info("Item Name: " + accessories.getItem_names());
				logger.info("Item Description: " + accessories.getItem_description());
				logger.info("Item Price: " + accessories.getItem_price());
				logger.info("/n");
			}
		}
*/
		CustomerTable customerTable = comp1.getCustomerTable();
		for (Customer customer : customerTable.getCustomers()) {
			logger.info("Customer ID: " + customer.getCustomer_id());
			logger.info("Username: " + customer.getUsername());
			logger.info("Password: " + customer.getPassword());
			logger.info("Full Name: " + customer.getFull_name());
			logger.info("Email: " + customer.getEmail());
			logger.info("/n");
		}

		MaintenanceTable maintenanceTable = comp1.getMaintenanceTable();
		for (Maintenance maintenance : maintenanceTable.getMaintenances()) {
			logger.info("Maintenance ID: " + maintenance.getMaintenanceId());
			logger.info("Computer ID: " + maintenance.getComputerId());
			logger.info("Maintenance Date: " + maintenance.getMaintenanceDate());
			logger.info("Details: " + maintenance.getDetails());
			logger.info("Maintenance Price: " + maintenance.getMaintenancePrice());
			logger.info("Maintenance Status: " + maintenance.getMaintenaceStatus());
			logger.info("Engineer Name: " + maintenance.getEngineerName());
			logger.info("/n");
		}

	}

	}




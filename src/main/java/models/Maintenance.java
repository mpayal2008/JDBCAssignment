package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Maintenance {

    @XmlElement(name = "maintenance_id")
    private String maintenanceId;

    @XmlElement(name = "computer_id")
    private String computerId;

    @XmlElement(name = "maintenance_date")
    private String maintenanceDate;

    private String details;

    @XmlElement(name = "maintenance_price")
    private double maintenancePrice;

    @XmlElement(name = "maintenace_status")
    private String maintenanceStatus;

    @XmlElement(name = "engineer_name")
    private String engineerName;


    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(double maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }


    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getMaintenaceStatus() {
        return maintenanceStatus;
    }
}

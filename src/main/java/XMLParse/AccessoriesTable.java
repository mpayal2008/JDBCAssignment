package XMLParse;



import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AccessoriesTable")
@XmlAccessorType(XmlAccessType.FIELD)


public class AccessoriesTable<> {

	 @XmlElement(name = "Accessories")
	 private List<Accessories> accessories;

	public List<Accessories> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessories> accessories1) {
		accessories = accessories1;
	}
	 
}


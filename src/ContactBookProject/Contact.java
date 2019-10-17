package ContactBookProject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 *  Represents a contact with fields <b>fullName</b> and <b>telNumber</b>
 */
@XmlRootElement(name = "contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
    @XmlElement(name = "name")
    private String fullName;
    @XmlElement(name = "tel")
    private String telNumber;

    /**
     * Empty constructor
     */
    public Contact() {
    }

    /**
     * @param fullName  <code>String</code> with first and last name
     * @param telNumber <code>String</code> that contains tel number for this contact
     */
    public Contact(String fullName, String telNumber) {
        this.fullName = fullName;
        this.telNumber = telNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return this.getFullName().equals(contact.getFullName()) &&
                this.getTelNumber().equals(contact.getTelNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFullName(), this.getTelNumber());
    }

    @Override
    public String toString() {
        return "Contact: " + fullName + ", tel - " + telNumber;
    }
}

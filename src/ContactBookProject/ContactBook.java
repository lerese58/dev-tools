package ContactBookProject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

/**
 * Represented collection of <code>Contact</code>s. Order by full name is supported
 */
@XmlRootElement(name = "contact-book")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactBook implements Serializable {
    @XmlElement(name = "contact")
    private SortedSet<Contact> set;

    /**
     * Constructor with no arguments, create an empty <code>ContactBook</code> with ordering by full name
     */
    public ContactBook() {
        this.set = new TreeSet<>((c1, c2) -> c1.getFullName().compareToIgnoreCase(c2.getFullName()));
    }

    /**
     * @param contactList collection of <code>Contact</code>s
     */
    public ContactBook(Collection<Contact> contactList) {
        this();
        this.set.addAll(contactList);
    }

    public SortedSet<Contact> getContactList() {
        return set;
    }

    /**
     * @param contact <code>Contact</code> to be added
     * @return  <code>true</code> - if contact has successfully added to <code>ContactBook</code><br/>
     *          <code>false</code> - if contact has already been in <code>ContactBook</code>
     */
    public boolean addContact(Contact contact) {
        return set.add(contact);
    }

    /**
     * @param contact <code>Contact</code> to be removed
     * @return  <code>true</code> - if contact has successfully removed from <code>ContactBook</code><br/>
     *          <code>false</code> - if contact is not found in <code>ContactBook</code>
     */
    public boolean removeContact(Contact contact) {
        return set.remove(contact);
    }

    /**
     * @param other <code>ContactBook</code> to be expanded with
     * @return      <code>true</code> - if at least one has been added<br/>
     *              <code>false</code> - in other cases
     */
    public boolean expandWith(ContactBook other) { return set.addAll(other.getContactList()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactBook that = (ContactBook) o;
        return set.equals(that.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactBook: \n");
        for (Contact contact : this.getContactList())
            sb.append(contact.toString()).append("\n");
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }

}

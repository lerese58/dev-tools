package ContactBookProject.Test;

import ContactBookProject.Contact;
import ContactBookProject.ContactBook;
import ContactBookProject.ContactBookLoader;
import ContactBookProject.ContactBookLoaderFromXML;
import org.junit.Before;
import org.junit.Test;


import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContactBookLoaderXMLTest {
    private ContactBookLoaderFromXML loaderXML;
    private ContactBook bookToLoad;

    @Before
    public void setUp() throws Exception {
        this.bookToLoad = new ContactBook();
        this.loaderXML = new ContactBookLoaderFromXML(new File("./"));
    }

    @Test
    public void loadDefaultBook() {
        String DEFAULT_BOOK_XML_PATH = "./src/ContactBookProject/Test/static/defaultBook.xml";
        loaderXML.setSource(new File(DEFAULT_BOOK_XML_PATH));
        List<Contact> list = new ArrayList<>();
        for (int i = 1; i < 6; i++)
            list.add(new Contact("testContact" + i, "7999" + i * 1111111));
        ContactBook expected = new ContactBook(list);
        try {
            bookToLoad = loaderXML.loadContactBook();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        assertEquals(bookToLoad, expected);
    }

    @Test
    public void loadEmptyBook() {
        String EMPTY_BOOK_XML_PATH = "./src/ContactBookProject/Test/static/emptyBook.xml";
        loaderXML.setSource(new File(EMPTY_BOOK_XML_PATH));
        ContactBook expected = new ContactBook();
        try {
            bookToLoad = loaderXML.loadContactBook();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        assertEquals(bookToLoad, expected);
    }
}

package ContactBookProject.Test;

import ContactBookProject.Contact;
import ContactBookProject.ContactBook;
import ContactBookProject.ContactBookDumperXML;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactBookDumperXMLTest {
    private ContactBookDumperXML dumperXML;
    private ContactBook book;

    @Before
    public void setUp() throws NoSuchFileException {
        this.dumperXML = new ContactBookDumperXML(new File("./"));
        List<Contact> list = new ArrayList<>();
        for (int i = 1; i < 6; i++)
            list.add(new Contact("testContact" + i, "7999" + i * 1111111));
        this.book = new ContactBook(list);
    }

    @Test
    public void dumpDefaultBook() {
        File DEFAULT_BOOK_XML = new File("./src/ContactBookProject/Test/static/defaultBook.xml");
        dumperXML.setDestination(DEFAULT_BOOK_XML);
        List<String> actual = readLinesFrom(DEFAULT_BOOK_XML);
        try {
            dumperXML.dump(book);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<String> expected = List.of("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",
                "<contact-book>",
                "    <contact>",
                "        <name>testContact1</name>",
                "        <tel>79991111111</tel>",
                "    </contact>",
                "    <contact>",
                "        <name>testContact2</name>",
                "        <tel>79992222222</tel>",
                "    </contact>",
                "    <contact>",
                "        <name>testContact3</name>",
                "        <tel>79993333333</tel>",
                "    </contact>",
                "    <contact>",
                "        <name>testContact4</name>",
                "        <tel>79994444444</tel>",
                "    </contact>",
                "    <contact>",
                "        <name>testContact5</name>",
                "        <tel>79995555555</tel>",
                "    </contact>",
                "</contact-book>");
        assertEquals(expected, actual);
    }

    @Test
    public void dumpEmptyBook() {
        File EMPTY_BOOK_XML = new File("./src/ContactBookProject/Test/static/emptyBook.xml");
        dumperXML.setDestination(EMPTY_BOOK_XML);
        book = new ContactBook();
        List<String> actual = readLinesFrom(EMPTY_BOOK_XML);
        try {
            dumperXML.dump(book);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<String> expected = List.of("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",
                "<contact-book/>");
        assertEquals(expected, actual);
    }

    private List<String> readLinesFrom(File fileXML) {
        List<String> lines = List.of();
        try {
            lines = Files.readAllLines(fileXML.toPath(), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

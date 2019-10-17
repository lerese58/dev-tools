package ContactBookProject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File fileXML = new File("./src/ContactBookProject/static/book.xml");
        ContactBookDumperXML dumperXML = new ContactBookDumperXML(fileXML);
        ContactBookLoaderFromXML loader = new ContactBookLoaderFromXML(fileXML);
        List<Contact> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(new Contact("Contact №" + i, "7999" + i * 1111111));
        }
        ContactBook bookToDump = new ContactBook(list);
        dumperXML.dump(bookToDump);
        ContactBook bookFromXML = loader.loadContactBook();
        System.out.println(bookFromXML);
    }
}

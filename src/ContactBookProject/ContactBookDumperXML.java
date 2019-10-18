package ContactBookProject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.NoSuchFileException;

/**
 * Implementation of interface <code>ContactBookDumper</code> for XML files
 */
public class ContactBookDumperXML implements ContactBookDumper {
    private File destination;

    /**
     * @param destinationFile XML file in which <code>ContactBook</code> will be written
     * @throws NoSuchFileException if there's no such file is found
     */
    public ContactBookDumperXML(File destinationFile) throws NoSuchFileException {
        if (!destinationFile.exists())
            throw new NoSuchFileException(destinationFile.getPath());
        this.destination = destinationFile;
    }

    /**
     * @param contactBook <code>ContactBook</code> to be written in file
     * @throws JAXBException if something goes wrong with JAXB
     */
    @Override
    public void dump(ContactBook contactBook) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Contact.class, ContactBook.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(contactBook, this.destination);
    }

    /**
     * @param fileXML XML file to be written
     * @return <code>true</code> - if a new destination is setted <br/>
     *         <code>false</code> - if there's no such file found
     */
    @Override
    public boolean setDestination(File fileXML) {
        if (fileXML.exists())
            this.destination = fileXML;
        return fileXML.exists();
    }
}

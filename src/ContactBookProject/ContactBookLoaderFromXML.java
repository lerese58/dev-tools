package ContactBookProject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.NoSuchFileException;


/**
 * Implementation of interface <code>ContactBookLoader</code> for XML files
 */
public class ContactBookLoaderFromXML implements ContactBookLoader {

    private File sourceFile;

    /**
     * @param sourceFile XML file in which <code>ContactBook</code> will be read
     * @throws NoSuchFileException if there's no such file is found
     */
    public ContactBookLoaderFromXML(File sourceFile) throws NoSuchFileException {
        if (!sourceFile.exists())
            throw new NoSuchFileException(sourceFile.getPath());
        this.sourceFile = sourceFile;
    }

    /**
     * @return <code>ContactBook</code> loaded from XML file by JAXB
     * @throws JAXBException if something goes wrong with JAXB
     */
    @Override
    public ContactBook loadContactBook() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Contact.class, ContactBook.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (ContactBook) unmarshaller.unmarshal(sourceFile);
    }

    /**
     * @param fileXML XML file to be read
     * @return <code>true</code> - if a new destination is setted <br/>
     *         <code>false</code> - if there's no such file found
     */
    @Override
    public boolean setSource(File fileXML) {
        if (fileXML.exists())
            this.sourceFile = fileXML;
        return fileXML.exists();
    }
}

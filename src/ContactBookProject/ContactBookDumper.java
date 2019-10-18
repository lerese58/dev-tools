package ContactBookProject;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface ContactBookDumper {

    /**
     * @param contactBook <code>ContactBook</code> to be written in file
     * @throws JAXBException
     */
    public void dump(ContactBook contactBook) throws JAXBException;

    /**
     * @param file <code>File</code> to be written
     * @return     if this <code>file</code> exists
     */
    public boolean setDestination(File file);
}

package ContactBookProject;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface ContactBookLoader {

    /**
     * @return <code>ContactBook</code> that was parsed from file by loader
     * @throws JAXBException if smth goes wrong
     */
    public ContactBook loadContactBook() throws JAXBException;

    /**
     * @param file <code>File</code> to be read
     * @return     if this <code>file</code> exists
     */
    public boolean setSource(File file);
}

